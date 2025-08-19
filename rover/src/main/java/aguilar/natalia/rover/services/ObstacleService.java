package aguilar.natalia.rover.services;

import aguilar.natalia.rover.models.Obstacle;

import java.util.List;

public interface ObstacleService {
    public List<Obstacle> findAll ();
    Obstacle save(Obstacle obstacle);
}
