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
    private LocalDate vremeIsteka;
    private String postavljen;
    @Column(columnDefinition = "TEXT")
    private String opis;
    @Column(nullable = false)
    private Long poslodavacId;

    public Oglas(String name, String mesto, LocalDate vremeIsteka, String opis, Long poslodavacId)
    {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.name = name;
        this.mesto = mesto;
        this.vremeIsteka = vremeIsteka;
        this.opis = opis;
        this.poslodavacId = poslodavacId;
        this.postavljen = LocalDate.now().format(df);
    }
}
