package t15.Oglasi.oglas;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Oglas {

    @Id
    @SequenceGenerator(name = "oglGen", sequenceName = "oglGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oglGen")
    private Long id;
    private String name;
    private String mesto;
    private LocalDateTime vremeIsteka;
    private LocalDateTime postavljen;
    @Column(columnDefinition = "TEXT")
    private String opis;
    @Column(nullable = false)
    private Long poslodavacId;
}
