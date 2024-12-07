package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exemple1Controller {
    @Autowired
    Facade facade;

    @GetMapping("/")
    public String menu() {
        return "menu";
    }

    @GetMapping("plante")
    public String plante(Model model) {
        model.addAttribute("listecomposites",facade.findAllCompositesPlante());
        return "listes";
    }

    @GetMapping("manuel")
    public String manuel(Model model) {
        model.addAttribute("listecomposites",facade.findAllCompositesManuel());
        return "listes";
    }

    @GetMapping("fetchjoin")
    public String fetchJoin(Model model) {
        model.addAttribute("listecomposites",facade.findAllCompositesFetchJoin());
        return "listes";
    }

    @GetMapping("entitygraph")
    public String entityGraph(Model model) {
        model.addAttribute("listecomposites",facade.findAllCompositesEntityGraph());
        return "listes";
    }

    @GetMapping("dto")
    public String dto(Model model) {
        model.addAttribute("listecomposites",facade.findAllCompositesDto());
        return "listesdto";
    }

}
