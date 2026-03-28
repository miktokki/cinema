package project.cinema.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class CinemaController {

    @GetMapping("/testi")
    public String teeTesti(Model model) {
        return "index";
    }

}
