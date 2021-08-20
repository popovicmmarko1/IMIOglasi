package t15.Oglasi.pageControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t15.Oglasi.oglas.Oglas;
import t15.Oglasi.oglas.OglasRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PodaciController {
    @Autowired
    private OglasRepository oglasRepository;
    private Optional<Oglas> o;

    @GetMapping("/oglas/id={id}")
    public Oglas oglasPoId(@PathVariable Long id, Model model){
        o = oglasRepository.findById(id);
        if(o.isPresent())
        {
            return o.get();
        }else
        {
            throw new IllegalStateException("Oglas nije prisutan!");
        }
    }

    @GetMapping("/oglasLista")
    public List<Oglas> sviOglasi()
    {
        List<Oglas> oglasi;

        oglasi = oglasRepository.findAll();

        return oglasi;
    }
}
