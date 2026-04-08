package project.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Write the movie title")
    @Size(min = 3, max = 100, message = "Title length must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Write the director’s name")
    @Size(min = 3, max = 100, message = "Must be 3–100 characters")
    private String director;

    @NotNull(message = "Enter the release year")
    @Min(value = 1000)
    @Max(value = 9999)
    private int publicationYear;

    @Min(value = 1, message = "Duration must be at least one minute")
    @Max(value = 500, message = "The movie duration can be at most 500 minutes")
    private int duration;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be positive")
    @DecimalMax(value = "100.0", message = "Price is too high")
    private double price;

    @NotNull(message = "Select a genre")
    @JsonIgnoreProperties("movies")
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Movie() {
    }

    public Movie(String title, String director, int publicationYear, int duration, double price, Genre genre) {
        this.title = title;
        this.director = director;
        this.publicationYear = publicationYear;
        this.duration = duration;
        this.price = price;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", publicationYear="
                + publicationYear + ", duration=" + duration + ", price=" + price + ", genre=" + genre + "]";
    }

}
