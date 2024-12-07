package services;

import entities.MyUser;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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


}
