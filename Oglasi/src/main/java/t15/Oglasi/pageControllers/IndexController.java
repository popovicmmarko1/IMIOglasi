package t15.Oglasi.pageControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.AppUser;
import t15.Oglasi.appUser.AppUserRepository;
import t15.Oglasi.grad.GradRepository;
import t15.Oglasi.oglas.OglasRepository;
import t15.Oglasi.tag.oblast.OblastRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    GradRepository gradRepository;
    @Autowired
    OblastRepository oblastRepository;
    @Autowired
    OglasRepository oglasRepository;



    @GetMapping(value = {"/", "/index", "/index.html"})
    public String home(Model model, Principal principal) {

        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }

        model.addAttribute("gradovi", gradRepository.findAll());
        model.addAttribute("oblasti", oblastRepository.findAll());

        model.addAttribute("poslovi6", oglasRepository.findTop6());

        return "index";
    }
}
