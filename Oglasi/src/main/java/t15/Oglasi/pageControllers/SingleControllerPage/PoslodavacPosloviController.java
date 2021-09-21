package t15.Oglasi.pageControllers.SingleControllerPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.oglas.Oglas;
import t15.Oglasi.oglas.OglasRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class PoslodavacPosloviController {
    @Autowired
    private final OglasRepository oglasRepository;
    @Autowired
    private final PoslodavacRepository poslodavacRepository;
    @Autowired
    private final AppUserRepository appUserRepository;

    public PoslodavacPosloviController(OglasRepository oglasRepository, PoslodavacRepository poslodavacRepository, AppUserRepository appUserRepository) {
        this.oglasRepository = oglasRepository;
        this.poslodavacRepository = poslodavacRepository;
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("objavljeni_poslovi")
    public String stranica(Model model, Principal principal, @RequestParam Optional<Integer> page)
    {
        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail1(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
                model.addAttribute("userId", ulogovan.get().getId());
                model.addAttribute("role", ulogovan.get().getAppUserRole());

                Page<Oglas> strana = oglasRepository.findByPoslodavacId(ulogovan.get().getId(), PageRequest.of(page.orElse(0), 6));
                System.out.println(strana.getContent().toString());
                model.addAttribute("oglasi", strana);
                model.addAttribute("nop", strana.getTotalPages());
                model.addAttribute("noe", strana.getTotalElements());

            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }


        return "moji_poslovi";
    }

}
