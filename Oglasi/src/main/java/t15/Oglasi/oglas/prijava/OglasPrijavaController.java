package t15.Oglasi.oglas.prijava;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping(value = "/prijavise")
@RestController
@AllArgsConstructor
public class OglasPrijavaController {
        @Autowired
        private final OglasPrijavaService oglasPrijavaService;

        @PostMapping
        public void prijava(OglasPrijava request, HttpServletResponse response) throws IOException {
                if(oglasPrijavaService.proveri(request))
                {
                        oglasPrijavaService.save(request);
                        System.out.println(request.getIdOglasa() + "id oglasa je ovaj");
                        response.sendRedirect("/oglas/?pageid=" + request.getIdOglasa());
                }else{
                        response.sendRedirect("/nije");
                }

        }
}
