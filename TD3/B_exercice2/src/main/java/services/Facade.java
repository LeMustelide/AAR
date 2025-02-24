package services;

import entities.MyUser;
import exceptions.UserAllreadyExistsException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

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


    public record Detail (
            String details,
            String email
    ) { }

    @Transactional
    public boolean checkLP(String login,String password) {
        // On va maintenant chercher l'utilisateur dans la BD à partir du login
        MyUser user=em.find(MyUser.class,login);
        if (user==null) {
            return false;
        } else {
            return (user.getPassword().equals(password));
        }
    }

    public MyUser createUser(String login, String password) throws UserAllreadyExistsException {
       MyUser user=em.find(MyUser.class,login);

        Detail detail = em.createQuery("SELECT NEW services.Facade$Detail(a.id, a.login) From MyUser a Where a.login = '343'", Detail.class).getSingleResult();
        if (user!=null) {
            throw new UserAllreadyExistsException();
        }
        user =new MyUser(login,password);
        em.persist(user);
        return user;
   }

    @Transactional
    public void deleteUser(String login) {
        MyUser user=em.find(MyUser.class,login);
        if (user!=null) {
            em.remove(user);
        }
    }

}
