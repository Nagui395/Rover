package aguilar.natalia.rover.models;

import lombok.Data;

import java.util.List;
@Data
public class Map {
    private static Map map;
    private int width;
    private int height;
    private final int MIN_WIDTH= 10;
    private final int MIN_HEIGHT= 10;


    private Map() {

        this.width= MIN_WIDTH;
        this.height= MIN_HEIGHT;
    }

    public static Map getInstance() {
        if (map == null) {
            map = new Map();
        }
        return map;
    }

    private Rover rover;
    private List<Obstacle> obstacleList;


}
