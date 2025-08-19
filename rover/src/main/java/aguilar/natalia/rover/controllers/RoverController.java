package aguilar.natalia.rover.controllers;

import aguilar.natalia.rover.dto.CommandDto;
import aguilar.natalia.rover.dto.RoverDto;
import aguilar.natalia.rover.logic.RoverNavigator;
import aguilar.natalia.rover.models.Map;
import aguilar.natalia.rover.models.Obstacle;
import aguilar.natalia.rover.models.Rover;
import aguilar.natalia.rover.services.ObstacleServiceImp;
import aguilar.natalia.rover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RoverController {

    @Autowired
    private RoverNavigator roverNavigator;

    @Autowired
    private ObstacleServiceImp obstacleService;

    @Autowired
    private RoverService service;

    @GetMapping("api/rover/")
    public Rover get() {
        return service.get();
    }


    @PostMapping("api/rover/")
    public void create(@RequestBody RoverDto rover) {

//        System.out.println(rover);
    }

    @PostMapping("api/rover/command")
    public Rover sendCommand(@RequestBody CommandDto commands) {
        Rover rover = service.get();
        List<Obstacle> obstacles = obstacleService.findAll();
        Map map = Map.getInstance();
        map.setObstacleList(obstacles);

        return roverNavigator.navigate(commands.getCommands());
//        for (String command: commands.getCommands()){
//        System.out.println(command);

        }
    }




