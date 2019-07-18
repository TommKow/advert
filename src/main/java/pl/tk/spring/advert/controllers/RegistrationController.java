package pl.tk.spring.advert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String prepareRegistrationPage() {
        //TO DO
        return "/registration-page.jsp";
    }

    @PostMapping
    public String procesRegistrationPage() {
        //TO DO
        return "";
    }

}

