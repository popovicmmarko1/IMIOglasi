package t15.Oglasi.pageControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import t15.Oglasi.oglas.Oglas;
import t15.Oglasi.oglas.OglasRepository;
import t15.Oglasi.slike.Slike;
import t15.Oglasi.slike.SlikeRepository;
import t15.Oglasi.tag.Tag;
import t15.Oglasi.tag.TagRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class PageController {

    @Autowired
    private OglasRepository oglasRepository;
    @Autowired
    private SlikeRepository slikeRepository;
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/")
    public String landing()
    {
        return "index";
    }

    @GetMapping("/oglas/pageid={id}")
    public String oglas(@PathVariable long id, Model model)
    {
        Optional<Oglas> o = oglasRepository.findById(id);
        List<Slike> s = slikeRepository.findByOglasId(id);
        List<Tag> t = tagRepository.findByOglasId(id);
        if(o.isPresent())
        {

            return "oglas";
        }else {
            return null;
        }
    }

    @GetMapping("/oglas/test")
    public String test(Model model)
    {



        return "oglas";
    }

}
