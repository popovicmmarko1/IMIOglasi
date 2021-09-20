package t15.Oglasi.pageControllers.SingleControllerPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.oglas.OglasRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    OglasRepository oglasRepository;


    @GetMapping(value = {"/", "/index", "/index.html"})
    public String home(Model model, Principal principal) {

        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail1(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
                model.addAttribute("userId", ulogovan.get().getId());
                model.addAttribute("role", ulogovan.get().getAppUserRole());
            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }

        System.out.println(oglasRepository.findTop6().toString());
        model.addAttribute("poslovi6", oglasRepository.findTop6());

        return "index";
    }
}
