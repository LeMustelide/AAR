package entities;

import java.util.List;
import java.util.Set;

public class EmployeDto {

    private int idEmp;
    private String prenom;
    private String nom;
    private List<Telephone> telephones;
    private Machine machine;
    private Service service;
    private Adresse adresse;
    private Set<Projet> projetsEnCours;



    public EmployeDto() {
    }

    public EmployeDto(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public EmployeDto(Employe e) {
        this.prenom = e.getPrenom();
        this.nom = e.getNom();
        this.telephones = e.getTelephones();
        this.machine = e.getMachine();
        this.service = e.getService();
        this.adresse = e.getAdresse();
        this.projetsEnCours = e.getProjetsEnCours();
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }
}
