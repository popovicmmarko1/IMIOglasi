package t15.Oglasi.tag;

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
public class Tag {


    @Id
    @SequenceGenerator(name = "tagGen", sequenceName = "tagGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tagGen")
    private Long id;
    private Long idOglasa;
    private String tag;
}
