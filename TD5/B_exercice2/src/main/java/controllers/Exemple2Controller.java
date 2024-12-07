package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exemple2Controller {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String hello(){
        return "hello";
    }
}
