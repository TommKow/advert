package pl.tk.spring.advert.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tk.spring.advert.domain.model.User;
import pl.tk.spring.advert.domain.repositories.AdvertRepository;

import java.security.Principal;

@Controller
@RequestMapping("/user-adverts")
public class UserAdvertsController {

    private AdvertRepository advertRepository;

    public UserAdvertsController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping("/{userId}")
    public String userAdverts(@PathVariable("userId") Long userId, Model model, User user) {
        //id = user.getId();
        model.addAttribute("userAdverts", advertRepository.findAllByUserIdOrderByPostedDesc(userId));
        return "user-advert-page";
    }
}
