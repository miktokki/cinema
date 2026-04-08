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

    private int capacity;

    public Screening() {
    }

    public Screening(Movie movie, Cinema cinema, LocalDateTime startTime, int capacity) {
        this.movie = movie;
        this.cinema = cinema;
        this.startTime = startTime;
        this.capacity = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Screening [id=" + id + ", movie=" + movie + ", cinema=" + cinema + ", startTime=" + startTime
                + ", capacity=" + capacity + "]";
    }

}
