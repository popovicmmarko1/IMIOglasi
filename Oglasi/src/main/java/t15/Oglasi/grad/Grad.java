package t15.Oglasi.grad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grad {

    @Id
    @SequenceGenerator(name = "gradGen", sequenceName = "gradGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gradGen")
    private Long id;
    private String ime;
}
