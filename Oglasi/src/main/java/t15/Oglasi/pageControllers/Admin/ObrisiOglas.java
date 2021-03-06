package t15.Oglasi.pageControllers.Admin;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t15.Oglasi.oglas.OglasService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/obrisioglas", method = RequestMethod.GET)
@AllArgsConstructor
public class ObrisiOglas {
    @Autowired
    private OglasService oglasService;


    @GetMapping()
    public void obrisiOglas(@RequestParam Long id, HttpServletResponse response) throws IOException {
        oglasService.obrisiOglas(id);
        response.sendRedirect("/admin_oglasi");
    }
}
