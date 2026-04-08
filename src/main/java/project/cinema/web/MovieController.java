package project.cinema.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import project.cinema.model.Cinema;
import project.cinema.model.CinemaRepository;
import project.cinema.model.GenreRepository;
import project.cinema.model.Movie;
import project.cinema.model.MovieRepository;
import project.cinema.model.Screening;
import project.cinema.model.ScreeningRepository;

@Controller
public class MovieController {

    private final MovieRepository movRepository;
    private final GenreRepository genRepository;
    private final ScreeningRepository scrRepository;
    private final CinemaRepository cinRepository;

    public MovieController(MovieRepository movRepository, GenreRepository genRepository,
            ScreeningRepository scrRepository, CinemaRepository cinRepository) {
        this.movRepository = movRepository;
        this.genRepository = genRepository;
        this.scrRepository = scrRepository;
        this.cinRepository = cinRepository;

    }

    @GetMapping("/addmovie")
    public String addMovie(@RequestParam String city, Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", genRepository.findAll());
        model.addAttribute("city", city);
        return "addmovie";
    }

    @PostMapping("/savemovie")
    public String saveMovie(@Valid @ModelAttribute Movie movie, BindingResult bindingResult,
            @RequestParam String city, @RequestParam String startTime, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genres", genRepository.findAll());
            model.addAttribute("city", city);
            return "addmovie";
        }

        Movie savedMovie = movRepository.save(movie);
        Cinema cinema = cinRepository.findByCityIgnoreCase(city).get(0);
        Screening screening = new Screening();
        screening.setMovie(savedMovie);
        screening.setCinema(cinema);
        screening.setStartTime(LocalDateTime.parse(startTime));
        scrRepository.save(screening);
        return "redirect:/";
    }

    @GetMapping(value = "/editmovie/{id}")
    public String editMovie(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movRepository.findById(id).orElseThrow());
        model.addAttribute("genres", genRepository.findAll());
        return "editmovie";
    }

    @PostMapping("/deletescreening/{id}")
    public String deleteScreening(@PathVariable Long id) {
        scrRepository.deleteById(id);
        return "redirect:/";
    }
}
