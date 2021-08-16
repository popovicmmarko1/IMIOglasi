package t15.Oglasi.oglas;

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
public class Oglas {

    @Id
    @SequenceGenerator(name = "oglGen", sequenceName = "oglGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oglGen")
    private Long id;
    private String name;
    private String opis;
    private String tags;
    private String slike;

    public Oglas(String name, String opis, String tags, String slike)
    {
        this.name = name;
        this.opis = opis;
        this.tags = tags;
        this.slike = slike;
    }



}
