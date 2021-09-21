package t15.Oglasi.appUser.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AppUserNova {
    private Long id;
    private String fName;
    private String lName;
    private String email;
    private String slika;
    private String bio;
    private String telefon;
}
