package controllers;

import dtos.UserDto;
import exceptions.UserAllreadyExistsException;
import exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import services.Facade;

@Controller
@SessionAttributes("courant")
@RequestMapping("/")
public class Exemple2Controller {
    @Autowired
    private Facade facade;
    @RequestMapping("")
    public String toLogin(Model model) {
        //ici on doit renvoyer un User du fait traitement avec modelAttribute et path côté jsp
        model.addAttribute(new UserDto());
        return("login");
    }

    // on passe un objet user en paramètre : mapping automatique des champs du formulaire
    // on jour aussi avec les messages d'erreurs (BindingResult) ...
    @PostMapping("login")
    public String checkLP(UserDto userDto, BindingResult result, Model model){
        if (facade.checkLP(userDto.getLogin(), userDto.getPassword())) {
            // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
            model.addAttribute("courant", userDto.getLogin());
            model.addAttribute("username", userDto.getLogin());
            model.addAttribute("users", facade.getAllUsers());
            return "welcome";
        } else {
            // on crée à la volée un "ObjectError" : erreur globale dans l'objet (ici l'objet c'est l'instance de user où transitent les infos de login)
            result.addError(new ObjectError("user","Les informations saisies ne correspondent pas à un utilisateur connu."));
            System.out.println(result.hasErrors());
            // le user du model est renvoyé tel quel à la jsp, et on préserve les valeurs saisies (comment réinitialiser ?)
            return "login";
        }
    }

    @PostMapping("register")
    public String register(UserDto userDto,BindingResult result, Model model){
        try {
            facade.createUser(userDto.getLogin(),userDto.getPassword());
        } catch (UserAllreadyExistsException e) {
            result.addError(new ObjectError("user","Ce login n'est pas disponible."));
            return "login";
        }
        model.addAttribute("courant", userDto.getLogin());
        model.addAttribute("username", userDto.getLogin());
        return "welcome";
    }


    @PostMapping("remove")
    public String remove(@RequestParam("login") String login, Model model) {
        try{
            facade.removeUser(login);
        } catch (UserNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            return "welcome";
        }
        model.addAttribute("users", facade.getAllUsers());
        return "welcome";
    }

    @RequestMapping("simplecheck")
    public String simpleCheck(@SessionAttribute("courant") String courant,Model model){
        System.out.println(courant);
        model.addAttribute("username",courant);
        return "welcome";
    }

    @RequestMapping("logout")
    public String logout(SessionStatus status,Model model) {
        status.setComplete();
        model.addAttribute("courant",null);
        model.addAttribute(new UserDto());
        return "login";
    }
}
