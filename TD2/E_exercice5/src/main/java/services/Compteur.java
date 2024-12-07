package services;

import org.springframework.stereotype.Service;

@Service
public class Compteur {
    private static Compteur instance=null;
    private int compteur=0;

    private Compteur(){
    }

    public static synchronized Compteur getInstance() {
        if (instance==null) {
            instance=new Compteur();
        }
        return instance;
    }

    public int getCompteur() {
        return compteur;
    }

    public void incrementer() {
        compteur++;
    }
}
