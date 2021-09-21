package t15.Oglasi.pageControllers.Admin;


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
public class AdminController {

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


    @GetMapping(value = {"admin_korisnici",  "/admin_korisnici.html"})
    public String admin_korisnici()
    {
        return "admin_korisnici";
    }

    @GetMapping(value = {"admin_oglasi",  "/admin_oglasi.html"})
    public String admin_oglasi()
    {
        return "admin_oglasi";
    }

    @GetMapping(value = {"admin_poslodavci",  "/admin_poslodavci.html"})
    public String admin_poslodavci()
    {
        return "admin_poslodavci";
    }


}