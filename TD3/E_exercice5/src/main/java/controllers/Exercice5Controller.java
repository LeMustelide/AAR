package controllers;


import dtos.UserDto;
import exceptions.UserAllreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
import services.Facade;


@Controller
@SessionAttributes("courant")
@RequestMapping("/")
public class Exercice5Controller {

    @Autowired
    private Facade facade;

    @GetMapping("")
    public String toLogin(Model model) {
        model.addAttribute(new UserDto());
        return "login";
    }

    @PostMapping("login")
    public String login(UserDto userDto, Model model) {
        model.addAttribute("courant", userDto.getLogin());
        model.addAttribute("username", userDto.getLogin());
        return "welcome";
    }

    @PostMapping("register")
    public String register(UserDto userDto, Model model) {
        try {
            facade.register(userDto.getLogin(), userDto.getPassword());
        } catch (UserAllreadyExistsException e) {
            throw new RuntimeException(e);
        }
        return "welcome";
    }
}
