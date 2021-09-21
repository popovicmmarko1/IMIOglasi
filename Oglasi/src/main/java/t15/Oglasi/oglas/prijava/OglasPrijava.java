package t15.Oglasi.oglas.prijava;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class OglasPrijava {

    @Id
    @SequenceGenerator(name = "poglGen", sequenceName = "poglGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poglGen")
    private Long id;
    private Long idKorisnika;
    private Long idOglasa;

    public OglasPrijava(Long idKorisnika, Long idOglasa) {
        this.idKorisnika = idKorisnika;
        this.idOglasa = idOglasa;
    }
}
