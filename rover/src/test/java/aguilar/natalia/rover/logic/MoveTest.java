package aguilar.natalia.rover.logic;

import aguilar.natalia.rover.models.Direction;
import aguilar.natalia.rover.models.Map;
import aguilar.natalia.rover.models.Rover;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {

    @ParameterizedTest
    @CsvSource({
            "0,0,NORTH,F,0,1",
            "0,0,R,NORTH,F,1,0",
            "0,0,NORTH,F,L,F,1,1"
    })
    void testMoveSequence(int startX, int startY, String startDirection, String commands, int expectedX, int expectedY) {
        Rover rover = new Rover(startX, startY);
        rover.setDirection(Direction.valueOf(startDirection));

        Map map = new Map();
        map.setObstacleList(new ArrayList<>());

        List<String> commandList = Arrays.asList(commands.split(","));

        for(String command : commandList) {
            Move.move(rover, map, command);
        }

        assertEquals(expectedX, rover.getX());
        assertEquals(expectedY, rover.getY());
    }


}
