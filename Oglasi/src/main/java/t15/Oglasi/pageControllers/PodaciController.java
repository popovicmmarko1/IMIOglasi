package t15.Oglasi.pageControllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    private Oglas o1;

    @GetMapping("/oglas/id={id}")
    public Map<String, String> oglasPoId(@PathVariable Long id){
        HashMap<String, String> map = new HashMap<>();

        o = oglasRepository.findById(id);
        if(o.isPresent())
        {
           o1 = o.get();
           map.put("id", o1.getId().toString());
           map.put("name", o1.getName());
           map.put("opis", o1.getOpis());
           map.put("slike", o1.getSlike());
           map.put("tags", o1.getTags());
        }else
        {
            throw new IllegalStateException("Oglas nije prisutan!");
        }
        return map;
    }

    @GetMapping("/oglasLista")
    public List<Oglas> sviOglasi()
    {
        List<Oglas> oglasi;

        oglasi = oglasRepository.findAll();

        return oglasi;



    }
}
