package aguilar.natalia.rover.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PositionUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "0,-1,3,3,0,2",
            "-1,0,3,3,2,0",
            "2,-1,3,3,2,2",
            "3,2,3,3,0,2",
            "0,3,3,3,0,0",
            "0,2,3,3,0,2",
            "2,3,3,3,2,0",
            "2,2,3,3,2,2",
            "1,3,3,3,1,0",
            "1,-1,3,3,1,2",
            "-1,1,3,3,2,1",
            "3,1,3,3,0,1"
    })

    public void wrapPositionTest(int x, int y, int mapWidth, int mapHeight, int expectedX, int expectedY) {
        int wrappedX = (x % mapWidth + mapWidth) % mapWidth;
        int wrappedY = (y % mapHeight + mapHeight) % mapHeight;

        int[] expected = {expectedX, expectedY};
        int[] actual = {wrappedX, wrappedY};

        assertArrayEquals(expected, actual);
    }

}

