package t15.Oglasi.appUser.profil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profil {

    @Id
    @SequenceGenerator(name = "profGen", sequenceName = "profGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profGen")
    private Long id;
    private Long AppUserId;
    private String mesto;
    private String brTelefona;
    private String opis;
    private LocalDateTime datumRodjenja;
}
