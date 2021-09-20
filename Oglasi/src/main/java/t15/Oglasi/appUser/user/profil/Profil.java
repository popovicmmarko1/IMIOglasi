package t15.Oglasi.appUser.user.profil;

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
    @Column(columnDefinition = "TEXT")
    private String opis;
    private LocalDateTime datumRodjenja;

    public Profil(Long appUserId, String mesto, String brTelefona, String opis, LocalDateTime datumRodjenja) {
        AppUserId = appUserId;
        this.mesto = mesto;
        this.brTelefona = brTelefona;
        this.opis = opis;
        this.datumRodjenja = datumRodjenja;
    }
}
