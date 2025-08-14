package aguilar.natalia.rover.services;

import aguilar.natalia.rover.models.Obstacle;
import aguilar.natalia.rover.repository.ObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObstacleServiceImp implements ObstacleService {

    @Autowired
    private ObstacleRepository repository;

    @Override
    public List<Obstacle> findAll() {
        return repository.findAll();
    }
}
