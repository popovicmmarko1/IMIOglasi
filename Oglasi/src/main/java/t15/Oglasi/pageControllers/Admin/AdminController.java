package t15.Oglasi.pageControllers.Admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserNova;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.appUser.user.profil.Profil;
import t15.Oglasi.appUser.user.profil.ProfilRepository;
import t15.Oglasi.oglas.OglasRepository;
import t15.Oglasi.oglas.OglasService;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
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
    public String admin_korisnici(Model model, Principal principal)
    {
        AppUser pomA;
        Profil pomP;
        List<AppUserNova> lista = new ArrayList<AppUserNova>();
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
        List<Long> idi = appUserRepository.findAllByRole();
        for (Long i : idi)
        {
            pomA = appUserRepository.findById1(i);
            pomP = profilRepository.findByAppUserId(i);

            lista.add(new AppUserNova(pomA.getId(), pomA.getFName(), pomA.getLName(), pomA.getEmail(), pomP.getSlika(), pomP.getOpis(), pomP.getBrTelefona()));

        }
        model.addAttribute("korisnici", lista);
        return "admin_korisnici";
    }



    @GetMapping(value = {"admin_oglasi",  "/admin_oglasi.html"})
    public String admin_oglasi(Model model, Principal principal)
    {
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
        System.out.println(oglasRepository.findAll().toString());
        model.addAttribute("sviOglasi", oglasRepository.findAll());
        return "admin_oglasi";
    }

    @GetMapping(value = {"admin_poslodavci",  "/admin_poslodavci.html"})
    public String admin_poslodavci(Model model, Principal principal)
    {
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
        model.addAttribute("poslodavci", poslodavacRepository.findAll());
        return "admin_poslodavci";
    }


}