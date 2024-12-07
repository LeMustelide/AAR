package dtos;

import entities.Composant;
import entities.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeDto {
    private int id;
    private String nom;
    private List<String> composants;

    public CompositeDto(){
    }

    public CompositeDto(Composite comp) {
        this();
        this.id=comp.getIdComposite();
        this.nom=comp.getNomComposite();
        this.composants=comp.getComposants().stream().map(c -> c.getIdComposant()+" "+c.getNomComposant()).collect(Collectors.toCollection(ArrayList::new));
    }

    public CompositeDto(int id, String nom, List<Composant> composants) {
        this.id = id;
        this.nom = nom;
        this.composants=composants.stream().map(c -> c.getIdComposant()+" "+c.getNomComposant()).collect(Collectors.toCollection(ArrayList::new));
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<String> getComposants() {
        return composants;
    }
}
