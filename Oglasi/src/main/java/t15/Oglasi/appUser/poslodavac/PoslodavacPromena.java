package t15.Oglasi.appUser.poslodavac;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class PoslodavacPromena {
    private Long id;
    private String naziv;
    private String grad;
    private String adresa;
    private String opis;
    private String telefon;
    private String email;
}
