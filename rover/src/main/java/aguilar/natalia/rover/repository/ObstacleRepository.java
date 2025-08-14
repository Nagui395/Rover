package aguilar.natalia.rover.repository;

import aguilar.natalia.rover.models.Obstacle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObstacleRepository extends JpaRepository<Obstacle, Long> {
}