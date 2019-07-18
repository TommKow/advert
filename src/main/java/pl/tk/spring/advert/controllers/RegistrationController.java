package pl.tk.spring.advert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.tk.spring.advert.domain.model.User;
import pl.tk.spring.advert.domain.repositories.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String prepareRegistrationPage() {
        //TO DO
        return "registration-page";
    }

    @PostMapping
    public String procesRegistrationPage(@ModelAttribute User user) {

        userRepository.save(user);
        return "redirect:/index.html";
    }

}

