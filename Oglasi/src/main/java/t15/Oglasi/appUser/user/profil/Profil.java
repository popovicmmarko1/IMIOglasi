package t15.Oglasi.appUser.user.profil;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Profil {

    @Id
    @SequenceGenerator(name = "profGen", sequenceName = "profGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profGen")
    private Long id;
    private Long AppUserId;
    private String mesto;
    private String brTelefona;
    @Column(columnDefinition = "TEXT")
    private String opis;
    private LocalDateTime datumRodjenja;
    private String slika;

    public Profil(Long appUserId, String mesto, String brTelefona, String opis, LocalDateTime datumRodjenja, String slika) {
        AppUserId = appUserId;
        this.mesto = mesto;
        this.brTelefona = brTelefona;
        this.opis = opis;
        this.datumRodjenja = datumRodjenja;
    }
}
