package controleurs;

import facades.Facade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/UrlControleur")
public class UrlControleur {
    private Facade facade=Facade.getInstance();

    @RequestMapping("")
    public String home(Model model){
        model.addAttribute("compteur",facade.getCompteurAsPairs());
        return "url";
    }

    @RequestMapping("/beau")
    public String beau(Model model) {
        String todo="beau";
        facade.ajout(todo);
        model.addAttribute("previoustodo",todo);
        model.addAttribute("compteur",facade.getCompteurAsPairs());
        return "url";
    }

    @RequestMapping("/bonjour")
    public String bonjour(Model model) {
        String todo="bonjour";
        facade.ajout(todo);
        model.addAttribute("previoustodo",todo);
        model.addAttribute("compteur",facade.getCompteurAsPairs());
        return "url";
    }

}
