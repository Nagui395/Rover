package aguilar.natalia.rover.controllers;

import aguilar.natalia.rover.dto.CommandDto;
import aguilar.natalia.rover.dto.RoverDto;
import aguilar.natalia.rover.models.Direction;
import aguilar.natalia.rover.models.Rover;
import aguilar.natalia.rover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoverController {

    @Autowired
    RoverService service;

    @GetMapping("api/rover/")
    public Rover get() {
        return service.get();
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
