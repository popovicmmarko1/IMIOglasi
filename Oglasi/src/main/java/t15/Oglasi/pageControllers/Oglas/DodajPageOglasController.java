package t15.Oglasi.pageControllers.Oglas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.user.AppUserRepository;

import java.security.Principal;

@Controller
public class DodajPageOglasController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping(value = {"dodaj_oglas",  "/dodaj_oglas.html"})
    public String dodaj_oglas(Model model, Principal principal)
    {
        model.addAttribute("userId", appUserRepository.findByEmail1(principal.getName()).get().getId());
        return "dodaj_oglas";
    }
}
