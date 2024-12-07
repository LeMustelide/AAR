package services;

import dtos.AddSeanceDTO;
import entities.Groupe;
import entities.Matiere;
import entities.Salle;
import entities.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.*;

import java.util.List;

@Service
public class Facade {
    GroupeRepo groupeRepo;
    MatiereRepo matiereRepo;
    PrerequisRepo prerequisRepo;
    SalleRepo salleRepo;
    SeanceRepo seanceRepo;

@Autowired
    public Facade(GroupeRepo groupeRepo, MatiereRepo matiereRepo, PrerequisRepo prerequisRepo, SalleRepo salleRepo, SeanceRepo seanceRepo) {
        this.groupeRepo = groupeRepo;
        this.matiereRepo = matiereRepo;
        this.prerequisRepo = prerequisRepo;
        this.salleRepo = salleRepo;
        this.seanceRepo = seanceRepo;
    }

    public Iterable<Salle> getAllSalles(){
        return salleRepo.findAll();
    }

    public Iterable<Groupe> getAllGroupes(){
        Iterable<Groupe> ig= groupeRepo.findAll();
        return ig;
    }

    public Iterable<Matiere> getAllMatieres(){
        return matiereRepo.findAll();
    }

    public Iterable<Seance> getAllSeances() {
        return seanceRepo.findAll();
    }

    public Seance addSeance(AddSeanceDTO seanceDTO) {
        Groupe groupe=groupeRepo.findById(seanceDTO.getIdGroupe()).get();
        Matiere matiere=matiereRepo.findById(seanceDTO.getIdMatiere()).get();
        Salle salle=salleRepo.findById(seanceDTO.getIdSalle()).get();
        Seance seance=new Seance(groupe,matiere,salle,seanceDTO.getDebut(),seanceDTO.getFin());
        return seanceRepo.save(seance);
    }


}
