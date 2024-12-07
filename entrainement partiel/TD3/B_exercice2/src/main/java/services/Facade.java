package services;

import entities.MyUser;
import exceptions.UserAllreadyExistsException;
import exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Collection;

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

    public Collection<MyUser> getAllUsers() {
        return em.createQuery("select u from MyUser u", MyUser.class).getResultList();
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
   public void removeUser(String login) throws UserNotFoundException {
       MyUser user=em.find(MyUser.class,login);
       if (user==null) {
           throw new UserNotFoundException();
       }
       em.remove(user);
   }

}
