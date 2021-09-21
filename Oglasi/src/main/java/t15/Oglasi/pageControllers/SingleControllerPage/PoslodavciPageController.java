package t15.Oglasi.pageControllers.SingleControllerPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class PoslodavciPageController {

    @Autowired
    private final AppUserRepository appUserRepository;
    @Autowired
    private final PoslodavacRepository poslodavacRepository;

    public PoslodavciPageController(AppUserRepository appUserRepository, PoslodavacRepository poslodavacRepository) {
        this.appUserRepository = appUserRepository;
        this.poslodavacRepository = poslodavacRepository;
    }

    @GetMapping(value = {"employers",  "/employers.html"})
    public String employers(Model model, Principal principal)
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

        model.addAttribute("poslodavci", poslodavacRepository.findAll());
        return "employers";
    }
}
