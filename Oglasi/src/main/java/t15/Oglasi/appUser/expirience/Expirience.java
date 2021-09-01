package t15.Oglasi.appUser.expirience;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Year;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expirience {

    @Id
    @SequenceGenerator(name = "expGen", sequenceName = "expGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expGen")
    private Long id;
    private Long appUserId;
    private String pozicija;
    private String firma;
    @Column(columnDefinition = "TEXT")
    private String opis;
    @Column(nullable = false)
    private Year godPocetka;
    @Column(nullable = true)
    private Year godKraja;
}
