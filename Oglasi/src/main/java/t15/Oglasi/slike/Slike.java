package t15.Oglasi.slike;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Slike {
    @Id
    @SequenceGenerator(name = "slikaGen", sequenceName = "slikaGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slikaGen")
    private Long id;
    private Long idOglasa;
    private String src;
}
