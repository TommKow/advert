package pl.tk.spring.advert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserAdvertsController {

    @GetMapping("/user-adverts")
    public String userAdverts(Model model, Principal principal) {
        
        return "user-advert-page";
    }
}
