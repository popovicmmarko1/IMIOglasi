package t15.Oglasi.pageControllers.Admin;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t15.Oglasi.appUser.user.AppUserService;
import t15.Oglasi.oglas.OglasService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/obrisiuser/", method = RequestMethod.GET)
@AllArgsConstructor
public class ObrisiUser {
    @Autowired
    private AppUserService appUserService;

    @GetMapping()
    public void obrisiOglas(@RequestParam Long id, HttpServletResponse response) throws IOException {
        appUserService.obrisiUser(id);
        response.sendRedirect("/admin_korisnici");
    }
}
