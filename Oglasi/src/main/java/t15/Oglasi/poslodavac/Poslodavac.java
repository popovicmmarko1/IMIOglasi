package t15.Oglasi.poslodavac;


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
public class Poslodavac{
    @Id
    @SequenceGenerator(name="posGen", sequenceName = "posGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posGen")
    private Long id;
    @Column(updatable = false, nullable = false)
    private Long idOglasa;
    @Column(columnDefinition = "TEXT")
    private String opis;
    @Column(columnDefinition = "TEXT")
    private String slika;
}