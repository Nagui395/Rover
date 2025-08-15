package aguilar.natalia.rover.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="rover")
public class Rover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="posx")
    private Integer x;
    @Column(name="posy")
    private Integer y;
    @Column(name="direction")
    @Enumerated(EnumType.STRING)
    private Direction direction;

    public Rover(int x, int y) {

    }
}
