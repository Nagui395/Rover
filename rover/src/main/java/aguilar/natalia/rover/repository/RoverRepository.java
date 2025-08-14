package aguilar.natalia.rover.repository;

import aguilar.natalia.rover.models.Rover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoverRepository extends JpaRepository<Rover,Long> {

}
