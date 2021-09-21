package t15.Oglasi.pageControllers.profil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.appUser.user.profil.Profil;
import t15.Oglasi.appUser.user.profil.ProfilRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProfilController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private ProfilRepository profilRepository;

    @GetMapping(value = {"profil"})
    public String profilTest(Model model, Principal principal) throws Throwable {
        AppUser user;
        Profil profil;


        try{

            Optional<AppUser> ulogovan = appUserRepository.findByEmail1(principal.getName());

            if(ulogovan.isPresent())
            {
                user = ulogovan.get();
                profil = profilRepository.findByAppUserId(user.getId());


                model.addAttribute("ime", user.getFName());
                model.addAttribute("prezime", user.getLName());
                model.addAttribute("userId", user.getId());

                model.addAttribute("mesto", profil.getMesto());
                model.addAttribute("bio", profil.getOpis());

                model.addAttribute("email", user.getEmail());
                model.addAttribute("telefon", profil.getBrTelefona());

            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }
        return "profil";
    }
}
