package aguilar.natalia.rover.logic;

import aguilar.natalia.rover.models.Direction;
import aguilar.natalia.rover.models.Map;
import aguilar.natalia.rover.models.Rover;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTest {

    @ParameterizedTest
    @CsvSource({


            "0,0,NORTH,F,0,1,NORTH",
            "0,0,NORTH,B,0,-1,NORTH",
            "0,0,EAST,F,1,0,EAST",
            "0,0,EAST,B,-1,0,EAST",
            "0,0,NORTH,L,0,0,WEST",
            "0,0,NORTH,R,0,0,EAST",
            "0,0,SOUTH,F,0,-1,SOUTH",
            "0,0,WEST,F,-1,0,WEST"

    })
    void moveSequenceTest(
            int startX, int startY, String startDirection,
            String commands, int expectedX, int expectedY, String expectedDirection) {

        Rover rover = new Rover(startX, startY);
        rover.setDirection(Direction.valueOf(startDirection));

        Map map = Map.getInstance();
        map.setObstacleList(new ArrayList<>());

        List<String> commandList = Arrays.asList(commands.split(","));

        for (String command : commandList) {
            Move.move(rover, map, command);
        }

        assertEquals(expectedX, rover.getX());
        assertEquals(expectedY, rover.getY());
        assertEquals(Direction.valueOf(expectedDirection), rover.getDirection());
    }

    @Test
    void moveInvalidCommandTest() {
        Rover rover = new Rover(0, 0);
        rover.setDirection(Direction.NORTH);
        Map map = Map.getInstance();
        map.setObstacleList(new ArrayList<>());

        // probamos un comando inválido "X"
        assertThrows(IllegalArgumentException.class, () -> Move.move(rover, map, "X"));
    }



}
