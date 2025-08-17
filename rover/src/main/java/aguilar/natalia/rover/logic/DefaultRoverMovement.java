package aguilar.natalia.rover.logic;

import aguilar.natalia.rover.models.Direction;
import aguilar.natalia.rover.models.Map;
import aguilar.natalia.rover.models.Rover;

    public class DefaultRoverMovement {

        public static void move(Rover rover, Map map, String command) {
            if (command == null || command.isBlank()) {
                throw new IllegalArgumentException("Comando no puede estar vacío");
            }

            String cmd = command.trim().toUpperCase();

            switch (cmd) {
                case "F":
                    moveForward(rover);
                    break;
                case "B":
                    moveBackward(rover);
                    break;
                case "L":
                    turnLeft(rover);
                    break;
                case "R":
                    turnRight(rover);
                    break;
                default:
                    throw new IllegalArgumentException("Comando inválido: " + command);
            }
        }

        private static void moveForward(Rover rover) {
            switch (rover.getDirection()) {
                case NORTH -> rover.setY(rover.getY() + 1);
                case SOUTH -> rover.setY(rover.getY() - 1);
                case EAST -> rover.setX(rover.getX() + 1);
                case WEST -> rover.setX(rover.getX() - 1);
            }
        }

        private static void moveBackward(Rover rover) {
            switch (rover.getDirection()) {
                case NORTH -> rover.setY(rover.getY() - 1);
                case SOUTH -> rover.setY(rover.getY() + 1);
                case EAST -> rover.setX(rover.getX() - 1);
                case WEST -> rover.setX(rover.getX() + 1);
            }
        }

        private static void turnLeft(Rover rover) {
            rover.setDirection(switch (rover.getDirection()) {
                case NORTH -> Direction.WEST;
                case WEST -> Direction.SOUTH;
                case SOUTH -> Direction.EAST;
                case EAST -> Direction.NORTH;
            });
        }

        private static void turnRight(Rover rover) {
            rover.setDirection(switch (rover.getDirection()) {
                case NORTH -> Direction.EAST;
                case EAST -> Direction.SOUTH;
                case SOUTH -> Direction.WEST;
                case WEST -> Direction.NORTH;
            });
        }
    }


