package t15.Oglasi.registracija;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String fName;
    private final String lName;
    private final String password;
    private final String email;
}
