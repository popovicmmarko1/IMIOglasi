package t15.Oglasi.appUser.poslodavac;


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
    private Long appUserId;
    private String naziv;
    private String adresa;
    private String grad;
    private String pib;
    private String telefon;
    @Column(columnDefinition = "TEXT")
    private String opis;
    @Column(columnDefinition = "TEXT")
    private String baner;
    @Column(columnDefinition = "TEXT")
    private String logo;


    public Poslodavac(Long appUserId, String naziv, String adresa, String grad, String pib, String telefon) {
        this.appUserId = appUserId;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.pib = pib;
        this.telefon = telefon;
    }
}
