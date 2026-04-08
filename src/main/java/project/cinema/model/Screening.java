package project.cinema.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Cinema cinema;

    private LocalDateTime startTime;

    public Screening() {
    }

    public Screening(Movie movie, Cinema cinema, LocalDateTime startTime) {
        this.movie = movie;
        this.cinema = cinema;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Screening [id=" + id + ", movie=" + movie + ", cinema=" + cinema + ", startTime=" + startTime + "]";
    }

}
