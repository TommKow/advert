package pl.tk.spring.advert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tk.spring.advert.domain.model.User;
import pl.tk.spring.advert.domain.repositories.AdvertRepository;
import pl.tk.spring.advert.domain.repositories.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomePageController {

    private AdvertRepository advertRepository;
    private UserRepository userRepository;
    @Autowired
    public HomePageController(AdvertRepository advertRepository, UserRepository userRepository) {
        this.advertRepository = advertRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String prepareHomePage(Model model, Principal principal, User user) {

        if (principal == null) {
            model.addAttribute("AdvertList", advertRepository.findFirst10ByOrderByPostedDesc());
        } else {
            String username = principal.getName();
            user = userRepository.findUserByUsername(username);
            model.addAttribute("AdvertList", advertRepository.findAllByOrderByPostedDesc());
            model.addAttribute("userId", user.getId());
        }
        return "home-page";
    }

}
