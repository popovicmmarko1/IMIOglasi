package t15.Oglasi.registracija.UserRegistracija;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import t15.Oglasi.appUser.user.AppUserRole;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String fName;
    private final String lName;
    private final String password;
    private final String email;
    private final AppUserRole role;
}
