package project.cinema.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import project.cinema.model.Genre;
import project.cinema.model.GenreRepository;
import project.cinema.model.MovieRepository;
import project.cinema.model.ScreeningRepository;

@Controller
public class CinemaController {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movRepository;

    public CinemaController(MovieRepository movRepository, ScreeningRepository screeningRepository) {
        this.movRepository = movRepository;
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/cinema/{city}")
    public String showCity(@PathVariable String city, Model model) {
        model.addAttribute("city", city);
        model.addAttribute("screenings", screeningRepository.findByCinema_CityIgnoreCase(city));
        return "cinema";
    }

}
