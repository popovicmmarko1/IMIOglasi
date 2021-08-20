package t15.Oglasi.oglas;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/postavioglas", method = RequestMethod.POST)
@AllArgsConstructor
public class OglasController {

    @Autowired
    private OglasService oglasService;

    @PostMapping
    public String dodaj(@RequestBody Oglas request)
    {
        return oglasService.postaviOglas(request);
    }
}
