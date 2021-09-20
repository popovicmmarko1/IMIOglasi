package t15.Oglasi.pageControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.appUser.user.profil.ProfilRepository;
import t15.Oglasi.oglas.OglasRepository;
import t15.Oglasi.oglas.OglasService;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class PageController {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private OglasRepository oglasRepository;
    @Autowired
    private OglasService oglasService;
    @Autowired
    private PoslodavacRepository poslodavacRepository;
    @Autowired
    private ProfilRepository profilRepository;

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }


    @GetMapping(value = {"blog",  "/blog.html"})
    public String blog(Model model, Principal principal)
    {
        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail1(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }

        return "blog";
    }

    @GetMapping(value = {"blog_details",  "/blog_details.html"})
    public String blog_details()
    {
        return "blog_details";
    }

    @GetMapping(value = {"_layout",  "/_layout.html"})
    public String layout()
    {
        return "_layout";
    }
}
