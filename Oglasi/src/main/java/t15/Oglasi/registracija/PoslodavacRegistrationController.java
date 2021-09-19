package t15.Oglasi.registracija;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t15.Oglasi.appUser.poslodavac.Poslodavac;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserService;
import t15.Oglasi.registracija.token.PRegistrationRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "registrationp")
@AllArgsConstructor
public class PoslodavacRegistrationController {

    private final AppUserService appUserService;
    private final PoslodavacRepository poslodavacRepository;

    public void pregister(PRegistrationRequest request, HttpServletResponse response) throws IOException {
        //korisnik i logovanje
        appUserService.signUser(new AppUser(request.getFName(), request.getLName(), request.getEmail(), request.getPassword(), request.getRole()));

        //poslodavac
        poslodavacRepository.save(new Poslodavac(request.getNaziv(), request.getAdresa(), request.getGrad(), request.getPIB(), request.getTelefon()));
        response.sendRedirect("/login");
    }

}
