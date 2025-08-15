import aguilar.natalia.rover.models.Map;
import aguilar.natalia.rover.models.Obstacle;
import aguilar.natalia.rover.utils.ObstacleBlockingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ObstacleBlockingUtilsTest {

    @BeforeEach
    public void setup() {
        // Reiniciamos la lista de obstáculos antes de cada test
        Map.getInstance().setObstacleList(new ArrayList<>());
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2,1,3,3,2,1",
            "2,2,2,3,2,3,2,2",
            "0,0,0,1,1,1,0,1"
    })
    public void testMoveRoverObstacle(int xActual, int yActual, int xDest, int yDest,
                                      int obsX, int obsY, int expectedX, int expectedY) {


        Obstacle obs = new Obstacle(obsX, obsX);
        obs.setX(obsX);
        obs.setY(obsY);
        Map.getInstance().getObstacleList().add(obs);


        int[] result = ObstacleBlockingUtils.moveRoverObstacle(xActual, yActual, xDest, yDest);


        assertArrayEquals(new int[]{expectedX, expectedY}, result);
    }
}
