package pl.tk.spring.advert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tk.spring.advert.domain.model.Advert;
import pl.tk.spring.advert.domain.repositories.AdvertRepository;
import pl.tk.spring.advert.domain.repositories.UserRepository;

import java.security.Principal;

@Controller
public class AdvertController {

    private UserRepository userRepository;
    private AdvertRepository advertRepository;

    @Autowired
    public AdvertController(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @PostMapping("/add-advert")
    public String addAdvert(@RequestParam String title, @RequestParam String description, Principal principal) {
        String username = principal.getName();
        Advert advert = new Advert();
        advert.setUser(userRepository.findUserByUsername(username));
        advert.setTitle(title);
        advert.setDescription(description);
        advertRepository.save(advert);
        return "redirect:/";
    }
}
