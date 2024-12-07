package controllers;

import dtos.AddSeanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exemple6Controller {
    @Autowired
    Facade facade;

    @GetMapping("")
    public String accueil(Model model){
        model.addAttribute("salles",facade.getAllSalles());
        model.addAttribute("groupes",facade.getAllGroupes());
        model.addAttribute("matieres",facade.getAllMatieres());
        model.addAttribute("seances",facade.getAllSeances());

        return "welcome";
    }

    @PostMapping("addseance")
    public String addSeance(AddSeanceDTO seanceDTO,Model model){
        facade.addSeance(seanceDTO);
        return accueil(model);
    }
}
