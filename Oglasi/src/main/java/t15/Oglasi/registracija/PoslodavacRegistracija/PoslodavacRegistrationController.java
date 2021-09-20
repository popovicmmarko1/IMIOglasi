package t15.Oglasi.registracija.PoslodavacRegistracija;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t15.Oglasi.appUser.poslodavac.Poslodavac;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(path = "registrationp")
@AllArgsConstructor
public class PoslodavacRegistrationController {

    private final AppUserService appUserService;
    private final PoslodavacRepository poslodavacRepository;

    @PostMapping()
    public void pregister(PRegistrationRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request);
        //korisnik i logovanje
        appUserService.signUser(new AppUser(request.getFName(), request.getLName(), request.getEmail(), request.getPassword(), request.getRole()));

        Optional<AppUser> pom = appUserService.findUser(request.getEmail());
        Long p = 0L;

        if(pom.isPresent())
        {
            p = pom.get().getId();
        }

        //poslodavac
        poslodavacRepository.save(new Poslodavac(p, request.getNaziv(), request.getAdresa(), request.getGrad(), request.getPIB(), request.getTelefon()));
        response.sendRedirect("/login");
    }

}
