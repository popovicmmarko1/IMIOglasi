package t15.Oglasi.pageControllers.profil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.poslodavac.Poslodavac;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.appUser.user.profil.Profil;
import t15.Oglasi.appUser.user.profil.ProfilRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProfilPoslodavacContriller {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PoslodavacRepository poslodavacRepository;

    @GetMapping("/profil_poslodavac")
    public String profilTest(Model model, Principal principal) throws Throwable {

        Optional<Poslodavac> pom_prof;
        Poslodavac poslodavac;



        try{

            Optional<AppUser> ulogovan = appUserRepository.findByEmail1(principal.getName());

            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
                model.addAttribute("userId", ulogovan.get().getId());
                model.addAttribute("role", ulogovan.get().getAppUserRole().toString());

                pom_prof = poslodavacRepository.findByID(ulogovan.get().getId());
                poslodavac = pom_prof.get();


                model.addAttribute("ime", ulogovan.get().getFName());
                model.addAttribute("prezime", ulogovan.get().getLName());
                model.addAttribute("userId", ulogovan.get().getId());

                model.addAttribute("naziv", poslodavac.getNaziv());
                model.addAttribute("mesto", poslodavac.getGrad());
                model.addAttribute("adresa", poslodavac.getAdresa());
                model.addAttribute("bio", poslodavac.getOpis());

                model.addAttribute("email", ulogovan.get().getEmail());
                model.addAttribute("telefon", poslodavac.getTelefon());

            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }
        return "profil_poslodavac";
    }
}
