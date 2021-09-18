package t15.Oglasi.tag.oblast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class OblastTag {
    @Id
    @SequenceGenerator(name = "oblastTagGen", sequenceName = "oblastTagGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oblastTagGen")
    private Long id;
    private Long idTag;
    private Long idOglas;
}
