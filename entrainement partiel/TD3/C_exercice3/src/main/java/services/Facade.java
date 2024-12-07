package services;

import entities.Message;
import entities.MyUser;
import exceptions.UserAllreadyExistsException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class Facade {
    // Injection de l'entity manager, pour accès à la BD
    @PersistenceContext
    private EntityManager em;

    // On n'utilise plus de map : on a une base de données
    //private Map<String,String> users;

    // le peuplement se fait maintenant avec un script sql
   /* @PostConstruct
    public void fillMap(){
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");
    }
    */


    public boolean checkLP(String login,String password) {
        // On va maintenant chercher l'utilisateur dans la BD à partir du login
        MyUser user=em.find(MyUser.class,login);
        if (user==null) {
            return false;
        } else {
            return (user.getPassword().equals(password));
        }
   }

   @Transactional
   public MyUser createUser(String login, String password) throws UserAllreadyExistsException {
        MyUser user=em.find(MyUser.class,login);
        if (user!=null) {
            throw new UserAllreadyExistsException();
        }
        user =new MyUser(login,password);
        em.persist(user);
        return user;
   }

   @Transactional
   public void createMessage(String strFrom, String strTo, String text){
        MyUser from=em.find(MyUser.class,strFrom);
        MyUser to=em.find(MyUser.class,strTo);
        Message m=new Message(text,from,to);
        em.persist(m);
   }

   public MyUser retrieveUser(String login) {
        return em.find(MyUser.class,login);
   }

   public List<String> getAllUserNames() {
        return em.createQuery("select u.login from MyUser u").getResultList();
   }

    public List<String> getAllUserNamesExcept(String name) {
        return em.createQuery("select u.login from MyUser u where u.login<>:n").setParameter("n",name).getResultList();
    }

   public Collection<Message> getReceivedMessage(String login){
        MyUser u=retrieveUser(login);
        return u.getReceived();
   }

    public Collection<Message> getSentMessage(String login){
        MyUser u=retrieveUser(login);
        return u.getSent();
    }

}
