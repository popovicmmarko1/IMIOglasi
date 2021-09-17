package t15.Oglasi.registracija;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import t15.Oglasi.appUser.AppUserRole;

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
