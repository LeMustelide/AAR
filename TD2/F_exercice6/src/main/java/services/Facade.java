package services;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class Facade {
    private static Facade instance=null;

    private final Compteur compteur;

    private Map<String,String> users;

    public Facade(Compteur compteur){
        this.compteur = compteur;
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");
    }

    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
   }

    public int getCompteur() {
         return compteur.getCompteur();
    }

    public void incrementer() {
        compteur.incrementer();
    }

}
