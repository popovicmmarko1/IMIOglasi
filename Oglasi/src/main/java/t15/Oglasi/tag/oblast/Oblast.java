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
public class Oblast {
    @Id
    @SequenceGenerator(name = "oblastGen", sequenceName = "oblastGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oblastGen")
    private Long id;
    private String naziv;
}
