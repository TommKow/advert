package pl.tk.spring.advert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tk.spring.advert.domain.repositories.AdvertRepository;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomePageController {

    private AdvertRepository advertRepository;
    @Autowired
    public HomePageController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String prepareHomePage(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("AdvertList", advertRepository.findFirst10ByOrderByPostedDesc());
        } else {
            model.addAttribute("AdvertList", advertRepository.findAllByOrderByPostedDesc());
        }
        return "home-page";
    }
   // @PostMapping("/add-advert")

}
