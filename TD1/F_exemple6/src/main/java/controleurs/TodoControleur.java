package controleurs;


import facades.Facade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
Pas vraiment dans l'esprit, mais permet de voir la manipulation des paramètre d'URL.
 */
@Controller
@RequestMapping("/TodoControleur")
public class TodoControleur {
    private Facade facade=Facade.getInstance();

    @RequestMapping("")
    public String whatToDo(@RequestParam(name = "TODO",required = false) String todo, Model model){
        if (todo!=null) {
            facade.ajout(todo);
            model.addAttribute("previoustodo",todo);
        }
        model.addAttribute("compteur",facade.getCompteurAsPairs());
        return "todo";
    }
}
