package t15.Oglasi.pageControllers.Admin;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t15.Oglasi.appUser.poslodavac.PoslodavacService;
import t15.Oglasi.appUser.user.AppUserService;
import t15.Oglasi.oglas.OglasService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/obrisiposlodavac/", method = RequestMethod.GET)
@AllArgsConstructor
public class ObrisiPoslodavac {
    @Autowired
    private PoslodavacService poslodavacService;

    @GetMapping()
    public void obrisiOglas(@RequestParam Long id, HttpServletResponse response) throws IOException {
        poslodavacService.obirsiPoslodavca(id);
        response.sendRedirect("/admin_poslodavci");
    }
}
