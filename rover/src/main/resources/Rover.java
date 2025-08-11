package aguilar.natalia.rover.models;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Rover {
    private Long id;
    private Integer x;
    private Integer y;
    private Direction direction;
}
