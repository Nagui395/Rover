package aguilar.natalia.rover.dto;

import aguilar.natalia.rover.models.Direction;
import lombok.Data;

@Data
public class RoverDto {
    private Integer x;
    private Integer y;
    private Direction direction;
}
