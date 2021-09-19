package t15.Oglasi.pageControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.oglas.Oglas;
import t15.Oglasi.oglas.OglasRepository;
import t15.Oglasi.appUser.poslodavac.Poslodavac;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;

import java.util.Optional;

@Controller
public class OglasPageController {
    @Autowired
    private OglasRepository oglasRepository;
    @Autowired
    private PoslodavacRepository poslodavacRepository;

    @GetMapping("/oglas/")
    public String oglas(@RequestParam long pageid, Model model)
    {
        System.out.println(pageid);
        Optional<Oglas> o = oglasRepository.findById(pageid);
        Optional<AppUser> optionalAppUser;
        AppUser appUser;

        Oglas oglas;
        if(o.isPresent())
        {
            oglas = o.get();
            model.addAttribute("naslov", oglas.getName());
            System.out.println(oglas.getName());
            model.addAttribute("mesto", oglas.getMesto());
            model.addAttribute("postavljen", oglas.getPostavljen().toString());
            model.addAttribute("istice", oglas.getVremeIsteka().toString());
            model.addAttribute("opis", oglas.getOpis());

            Optional <Poslodavac> p = poslodavacRepository.findById(oglas.getPoslodavacId());

            if(p.isPresent())
            {
                Poslodavac poslodavac = p.get();
                model.addAttribute("poslodavac_ime", poslodavac.getNaziv());
                model.addAttribute("poslodavac_opis", poslodavac.getOpis());
                model.addAttribute("poslodavac_slika", poslodavac.getBaner());
                model.addAttribute("poslodavac_slika", poslodavac.getLogo());
            }else{
                throw new IllegalStateException("Poslodavac ne postoji!");
            }

            return "oglas";
        }else {
            throw new IllegalStateException("Oglas ne postoji!");
        }
    }
}
