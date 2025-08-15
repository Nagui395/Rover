package aguilar.natalia.rover.acceptanceTest;

import aguilar.natalia.rover.models.Rover;
import aguilar.natalia.rover.utils.PositionUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapStepDefinitions {

    private int mapWidth;
    private int mapHeight;
    private Rover rover;


    @Given("un mapa {int}x{int}")
    public void MapDimension(int width, int height) {
        this.mapWidth = width;
        this.mapHeight = height;

    }

    @Given("un objeto en la posición ({int},{int})")
    public void roverPosition(int x, int y) {
//  guardo en memoria no en BBDD
        rover = new Rover(x, y);
    }


    @When("el objeto se mueve {int} paso(s) a la {word}")
    public void roverMovement(int pasos, String direccion) {

        switch (direccion.toLowerCase().trim()) {
            case "izquierda":
                rover.setX(rover.getX() - pasos);
                break;

            case "abajo":
                rover.setY(rover.getY() - pasos);
                break;

            case "derecha":
                rover.setX(rover.getX() + pasos);
                break;


            case "arriba":
                rover.setY(rover.getY() + pasos);
                break;

            default:
                throw new IllegalArgumentException("Direccion desconocida");

        }

        int[] pos = PositionUtils.wrapPosition(rover.getX(), rover.getY(), mapWidth, mapHeight);
        rover.setX(pos[0]);
        rover.setY(pos[1]);

    }
    @Then("la posición del objeto debe ser ({int},{int})")
    public void checkRoverPosition(int expectedX, int expectedY) {
        assertEquals(expectedX, rover.getX(), "La posición X del rover corregida es incorrecta");
        assertEquals(expectedY, rover.getY(), "La posición Y del rover corregida es incorrecta");
    }
}

