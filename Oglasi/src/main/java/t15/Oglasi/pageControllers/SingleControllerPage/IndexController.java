package t15.Oglasi.pageControllers.SingleControllerPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.appUser.user.AppUserRole;
import t15.Oglasi.oglas.OglasRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    OglasRepository oglasRepository;
    @Autowired
    PoslodavacRepository poslodavacRepository;


    @GetMapping(value = {"/", "/index"})
    public String home(Model model, Principal principal) {

        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail1(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
                model.addAttribute("userId", ulogovan.get().getId());
                model.addAttribute("role", ulogovan.get().getAppUserRole().toString());
            }else
            {
                System.out.println("Korisnik nije ulogovan!");
                model.addAttribute("username", "null");
            }
        }catch (Exception e){
            System.out.println("Naisao sam na gresku!");
        }
        model.addAttribute("poslodavci5", poslodavacRepository.dajPet());
        model.addAttribute("poslovi6", oglasRepository.findTop6());

        return "index";
    }
}
