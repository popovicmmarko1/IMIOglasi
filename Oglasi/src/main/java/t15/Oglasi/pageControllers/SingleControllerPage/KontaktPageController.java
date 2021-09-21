package t15.Oglasi.pageControllers.SingleControllerPage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class KontaktPageController {

    private final AppUserRepository appUserRepository;

    public KontaktPageController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @GetMapping(value = {"contact",  "/contact.html"})
    public String contact(Model model, Principal principal)
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

        return "contact";
    }
}
