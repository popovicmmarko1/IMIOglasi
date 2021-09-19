package t15.Oglasi.oglas;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Oglas {

    @Id
    @SequenceGenerator(name = "oglGen", sequenceName = "oglGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oglGen")
    private Long id;
    private String name;
    private String mesto;
    @Column(columnDefinition = "TEXT")
    private String opis;
    private String vremeIsteka;
    private String postavljen;
    @Column(nullable = false)
    private Long poslodavacId;
    private String oblast;
    private String pol;
    private String radnoIskustvo;
    private String radnoVreme;
    private String tipZaposlenja;
    private String visinaPlate;
    private String nivoObrazovanja;
    private String baner;

    public Oglas(String name, String mesto, String opis, String vremeIsteka, Long poslodavacId, String oblast, String pol, String radnoIskustvo, String radnoVreme, String tipZaposlenja,
                    String visinaPlate, String nivoObrazovanja)
    {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.name = name;
        this.mesto = mesto;
        this.vremeIsteka = vremeIsteka;
        this.opis = opis;
        this.poslodavacId = 1L;
        this.postavljen = LocalDate.now().format(df);
        this.oblast = oblast;
        this.pol = pol;
        this.radnoIskustvo = radnoIskustvo;
        this.radnoVreme = radnoVreme;
        this.tipZaposlenja = tipZaposlenja;
        this.visinaPlate = visinaPlate;
        this.nivoObrazovanja  = nivoObrazovanja;
    }
}
