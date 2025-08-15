package aguilar.natalia.rover.utils;


public class PositionUtils {
    private int x;
    private int y;

        public static int[] wrapPosition(int x, int y, int mapWidth, int mapHeight) {
            int wrappedX = (x % mapWidth + mapWidth) % mapWidth;
            int wrappedY = (y % mapHeight + mapHeight) % mapHeight;
            return new int[] { wrappedX, wrappedY };
        }

}

