package pl.tk.spring.advert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tk.spring.advert.domain.repositories.AdvertRepository;

@Controller
@RequestMapping("/")
public class HomePageController {

    private AdvertRepository advertRepository;
    @Autowired
    public HomePageController(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String prepareHomePage(Model model) {
        model.addAttribute("AdvertList", advertRepository.findAllByOrderByPostedDesc());
        return "home-page";
    }
   // @PostMapping("/add-advert")

}
