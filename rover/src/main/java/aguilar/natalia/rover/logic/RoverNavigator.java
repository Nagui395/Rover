package aguilar.natalia.rover.logic;

import aguilar.natalia.rover.models.Map;
import aguilar.natalia.rover.models.Obstacle;
import aguilar.natalia.rover.models.Rover;
import aguilar.natalia.rover.services.ObstacleService;
import aguilar.natalia.rover.services.RoverService;
import aguilar.natalia.rover.utils.ObstacleBlockingUtils;
import aguilar.natalia.rover.utils.MapWrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service
    public class RoverNavigator {

        @Autowired
        private RoverService roverService;

        @Autowired
        private ObstacleService obstacleService;

        public Rover navigate(List<String> commands) {
            Rover rover = roverService.get();

            Map map = Map.getInstance();

            List<Obstacle> obstacles = map.getObstacleList();
            if (obstacles == null) {
                obstacles = new ArrayList<>();
                map.setObstacleList(obstacles);//Si faltara la inicialización, meto dentro los datos obtenidos.
            }

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


