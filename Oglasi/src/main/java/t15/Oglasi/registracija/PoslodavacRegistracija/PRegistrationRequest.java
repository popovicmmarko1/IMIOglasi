package t15.Oglasi.registracija.PoslodavacRegistracija;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import t15.Oglasi.appUser.user.AppUserRole;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class PRegistrationRequest {
    private final String fName;
    private final String lName;
    private final String password;
    private final String email;
    private final AppUserRole role;
    private final String naziv;
    private final String adresa;
    private final String grad;
    private final String PIB;
    private final String telefon;
}
