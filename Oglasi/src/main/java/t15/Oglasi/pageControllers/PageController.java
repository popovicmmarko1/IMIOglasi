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

import java.time.LocalDateTime;
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
        Oglas o = new Oglas(1L, "Posao 1", "Mesto 1", LocalDateTime.now().plusDays(20));
        model.addAttribute("naslov", "Posao 1");
        model.addAttribute("mesto", "Mesto 1");
        model.addAttribute("istice", LocalDateTime.now().plusDays(20).toString());
        model.addAttribute("poslodavac", "Poslodavac 1");
        model.addAttribute("opis", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        model.addAttribute("poslodavac_opis", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
        return "oglas";
    }

}
