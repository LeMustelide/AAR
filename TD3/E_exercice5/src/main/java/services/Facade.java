package services;

import entities.User;
import exceptions.UserAllreadyExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class Facade {
    @PersistenceContext
    private EntityManager em;


    public boolean login(String login, String password) {
        User user = em.find(User.class, login);
        if(user == null) {
            return false;
        } else {
            return user.getPassword().equals(password);
        }
    }

    public void register(String login, String password) throws UserAllreadyExistsException {
        if(em.find(User.class, login) != null) {
            throw new UserAllreadyExistsException();
        }
        User user = new User(login, password);
        em.persist(user);
    }
}
