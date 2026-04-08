package project.cinema.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ScreeningRepository extends CrudRepository<Screening, Long> {
    List<Screening> findByCinema_CityIgnoreCase(String city);

    List<Screening> findByMovie_Id(Long Movie_Id);
}
