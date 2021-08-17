package t15.Oglasi.oglas;

import lombok.*;

import javax.persistence.*;

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
}
