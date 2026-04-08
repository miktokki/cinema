package project.cinema.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CinemaRepository extends CrudRepository<Cinema, Long> {
    List<Cinema> findByCityIgnoreCase(String city);
}
