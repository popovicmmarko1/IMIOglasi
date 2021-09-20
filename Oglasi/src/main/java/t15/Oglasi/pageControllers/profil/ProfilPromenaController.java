package t15.Oglasi.pageControllers.profil;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import t15.Oglasi.appUser.user.AppUserService;
import t15.Oglasi.appUser.user.profil.ProfilRequest;
import t15.Oglasi.appUser.user.profil.ProfilService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/profilpromena", method = RequestMethod.POST)
@AllArgsConstructor
public class ProfilPromenaController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private ProfilService profilService;

    @PostMapping
    public String promeniProfil(ProfilRequest request, HttpServletResponse response) throws IOException {

        Long id = request.getUserId();
        System.out.println(request);
        if(!request.getIme().equals("")) {
            appUserService.updateIme(request.getIme(), id);
        }
        if(!request.getPrezime().equals("")) {
            appUserService.updatePrezime(request.getPrezime(), id);
        }
        if(!request.getEmail().equals("")) {
            appUserService.updateEmail(request.getEmail(), id);
            response.sendRedirect("/logout");
            return "OK";
        }
        if(!request.getBio().equals("")) {
            profilService.updateBio(request.getBio(), id);
        }
        if(!request.getTelefon().equals("")) {
            profilService.updateTelefon(request.getTelefon(), id);
        }
        if(!request.getMesto().equals("")) {
            profilService.updateMesto(request.getMesto(), id);
        }
        response.sendRedirect("/profil");
        return "OK";
    }
}
