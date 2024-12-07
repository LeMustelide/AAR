package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exemple4Controller {
    @Autowired
    Facade facade;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }


    @RequestMapping("peupler")
    public String peuple(){
        System.out.println("peuple");
        facade.peuple();
        return "hello";
    }
}
