package project.cinema;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.cinema.model.AppUserRepository;
import project.cinema.model.Cinema;
import project.cinema.model.CinemaRepository;
import project.cinema.model.Genre;
import project.cinema.model.GenreRepository;
import project.cinema.model.Movie;
import project.cinema.model.MovieRepository;
import project.cinema.model.Screening;
import project.cinema.model.ScreeningRepository;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(MovieRepository movRepository, GenreRepository genRepository,
			AppUserRepository auRepository, CinemaRepository cinRepository, ScreeningRepository scrRepository) {
		return (args) -> {
			if (scrRepository.count() == 0) {
				Genre action = new Genre("Action");
				Genre drama = new Genre("Drama");
				Genre comedy = new Genre("Comedy");
				Genre scifi = new Genre("Sci-fi");
				Genre horror = new Genre("Horror");

				genRepository.save(action);
				genRepository.save(drama);
				genRepository.save(comedy);
				genRepository.save(scifi);
				genRepository.save(horror);

				Movie movie1 = new Movie("Inception", "Christopher Nolan", 2010, 148, 15.0, scifi);
				Movie movie2 = new Movie("The Dark Knight", "Christopher Nolan", 2008, 152, 14.0, action);
				Movie movie3 = new Movie("Interstellar", "Christopher Nolan", 2014, 169, 16.0, scifi);

				movRepository.save(movie1);
				movRepository.save(movie2);
				movRepository.save(movie3);

				Cinema helsinki = new Cinema("Tennispalatsi", "Helsinki");
				Cinema tampere = new Cinema("Plevna", "Tampere");
				Cinema turku = new Cinema("Kinopalatsi", "Turku");

				cinRepository.save(helsinki);
				cinRepository.save(tampere);
				cinRepository.save(turku);

				scrRepository.save(new Screening(movie1, helsinki, LocalDateTime.of(2026, 4, 7, 18, 0)));
				scrRepository.save(new Screening(movie2, helsinki, LocalDateTime.of(2026, 4, 7, 21, 0)));
				scrRepository.save(new Screening(movie3, tampere, LocalDateTime.of(2026, 4, 7, 19, 30)));
				scrRepository.save(new Screening(movie1, turku, LocalDateTime.of(2026, 4, 7, 20, 15)));
				scrRepository.save(new Screening(movie3, turku, LocalDateTime.of(2026, 4, 8, 18, 45)));

			}
		};
	}

}
