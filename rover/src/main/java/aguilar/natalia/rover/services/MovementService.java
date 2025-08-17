package aguilar.natalia.rover.services;

import aguilar.natalia.rover.logic.DefaultRoverMovement;
import aguilar.natalia.rover.models.Map;
import aguilar.natalia.rover.models.Rover;
import aguilar.natalia.rover.utils.ObstacleBlockingUtils;
import aguilar.natalia.rover.utils.MapWrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class MovementService {

        @Autowired
        private RoverService roverService;

        @Autowired
        private ObstacleService obstacleService;

        public Rover navigate(List<String> commands) {
            Rover rover = roverService.get();

            Map map = Map.getInstance();

            for (String command : commands) {
                int prevX = rover.getX();
                int prevY = rover.getY();

                DefaultRoverMovement.move(rover, map, command);

                int[] wrapped = MapWrapperUtils.wrapPosition(
                        rover.getX(), rover.getY(),
                        map.getWidth(), map.getHeight()
                );

                int newX = wrapped[0];
                int newY = wrapped[1];

                // Validación de obstáculos
                int[] validated = ObstacleBlockingUtils.moveRoverObstacle(prevX, prevY, newX, newY);

                rover.setX(validated[0]);
                rover.setY(validated[1]);
            }
            roverService.update(rover);
            return rover;
        }
    }


