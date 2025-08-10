package aguilar.natalia.rover.models;


import lombok.Data;

@Data
public class Rover {
    private Long id;
    private Integer x;
    private Integer y;
    private Direction direction;
}
