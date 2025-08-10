package aguilar.natalia.rover.controllers;

import aguilar.natalia.rover.dto.CommandDto;
import aguilar.natalia.rover.dto.RoverDto;
import aguilar.natalia.rover.models.Direction;
import aguilar.natalia.rover.models.Rover;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoverController {


    @GetMapping("api/rover/")
    public Rover get() {
        Rover rover= new Rover();
        rover.setX(1);
        rover.setY(6);
        rover.setDirection(Direction.EAST);
        return rover;
    }


    @PostMapping("api/rover/")
    public void create(@RequestBody RoverDto rover) {
        System.out.println(rover);
    }

    @PostMapping("api/rover/command")
    public void sendCommand(@RequestBody CommandDto commands) {
        System.out.println(commands);

        for (String command: commands.getCommands()){
            System.out.println(command);

        }
    }

}
