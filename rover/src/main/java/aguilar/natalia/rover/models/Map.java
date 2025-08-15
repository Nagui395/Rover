package aguilar.natalia.rover.models;

import lombok.Data;

import java.util.List;
@Data
public class Map {
    private static Map map;

    private Map() { }

    public static Map getInstance() {
        if (map == null) {
            map = new Map();
        }
        return map;
    }

    private Rover rover;
    private List<Obstacle> obstacleList;


}
