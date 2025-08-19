package aguilar.natalia.rover.utils;

import aguilar.natalia.rover.models.Map;
import aguilar.natalia.rover.models.Obstacle;

import java.util.List;

public class ObstacleBlockingUtils {



    public static int[] moveRoverObstacle(int xActual, int yActual, int xDest, int yDest) {
        List<Obstacle> obstacles = Map.getInstance().getObstacleList();

        for (Obstacle obs : obstacles) {
            if (obs.getX().equals(xDest) && obs.getY().equals(yDest)) {
                return new int[]{xActual, yActual};
            }
        }

        return new int[]{xDest, yDest};
    }

}


