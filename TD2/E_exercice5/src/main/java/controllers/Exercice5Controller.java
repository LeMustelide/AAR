package controllers;

import dtos.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import services.Facade;

@Controller
@SessionAttributes("courant")
@RequestMapping("/")
public class Exercice5Controller {
    private final Facade facade;

    public Exercice5Controller(Facade facade) {
        this.facade = facade;
    }

    @RequestMapping("")
    public String toLogin() {
        return("login");
    }

    // on passe un objet user en paramètre : mapping automatique des champs du formulaire
    // on joue aussi avec les messages d'erreurs (BindingResult) ...
    @RequestMapping("login")
    public String checkLP(User user, Model model){
        facade.incrementer();
        if (facade.checkLP(user.getLogin(),user.getPassword())) {
            // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
            model.addAttribute("courant",user.getLogin());
            model.addAttribute("username",user.getLogin());
            model.addAttribute("compteur",facade.getCompteur());
            return "welcome";
        } else {
            // on ajoute un simple message d'erreur au modèle...
            model.addAttribute("error","Les informations saisies ne correspondent pas à un utilisateur connu.");
            return "login";
        }
    }

    @RequestMapping("simplecheck")
    public String simpleCheck(@SessionAttribute("courant") String courant,Model model){
        facade.incrementer();
        System.out.println(courant);
        model.addAttribute("username",courant);
        return "welcome";
    }

    @RequestMapping("logout")
    public String logout(SessionStatus status) {
        facade.incrementer();
        status.setComplete();
        return "login";
    }
}
