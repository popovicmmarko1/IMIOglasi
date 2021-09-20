package t15.Oglasi.registracija.UserRegistracija;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.appUser.user.profil.Profil;
import t15.Oglasi.appUser.user.profil.ProfilRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final AppUserRepository appUserRepository;
    private final RegistrationService registrationService;
    private final ProfilRepository profilRepository;

    @PostMapping()
    public void register(RegistrationRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request);
        registrationService.register(request);

        profilRepository.save(new Profil(appUserRepository.findByEmail1(request.getEmail()).get().getId(), "", "", "", null));

        response.sendRedirect("/login");
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token)
    {
        return registrationService.confirmToken(token);
    }
}
