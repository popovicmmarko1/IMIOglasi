package t15.Oglasi.pageControllers.SingleControllerPage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.appUser.user.profil.Profil;
import t15.Oglasi.appUser.user.profil.ProfilRepository;
import t15.Oglasi.oglas.Oglas;
import t15.Oglasi.oglas.OglasRepository;
import t15.Oglasi.oglas.prijava.OglasPrijava;
import t15.Oglasi.oglas.prijava.OglasPrijavaRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class PrijavljeniKandidati {

    @Autowired
    private final AppUserRepository appUserRepository;
    @Autowired
    private final ProfilRepository profilRepository;
    @Autowired
    private final OglasRepository oglasRepository;
    @Autowired
    private final OglasPrijavaRepository oglasPrijavaRepository;


    public PrijavljeniKandidati(AppUserRepository appUserRepository, ProfilRepository profilRepository, OglasRepository oglasRepository, OglasPrijavaRepository oglasPrijavaRepository) {
        this.appUserRepository = appUserRepository;
        this.profilRepository = profilRepository;
        this.oglasRepository = oglasRepository;
        this.oglasPrijavaRepository = oglasPrijavaRepository;
    }


    @GetMapping("/prijavljeni_kandidati")
    public String strana(Model model, Principal principal, @RequestParam Optional<Long> id)
    {
        //korisnike poslati kao "korisnici"

        //unutar oglasa
            //posao naziv

        List<Long> prijave = oglasPrijavaRepository.findByOglasId(id.orElse(0L));
        List<pomocna> pom = new ArrayList<pomocna>();
        Profil profil;
        AppUser user;

        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail1(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
                model.addAttribute("userId", ulogovan.get().getId());
                model.addAttribute("role", ulogovan.get().getAppUserRole());
                for (Long i : prijave)
                {
                    profil = profilRepository.findByAppUserId(i);
                    user = appUserRepository.findById1(i);

                    pom.add(new pomocna(user.getId(), user.getFName(), user.getLName(), user.getEmail(), profil.getBrTelefona(), profil.getOpis()));
                }
                model.addAttribute("korisnici", pom);
                System.out.println(pom.toString());
                model.addAttribute("naziv", oglasRepository.getById(oglasPrijavaRepository.findById(id.orElse(0l)).get().getId()).getName());
            }else
            {

                System.out.println("Korisnik nije ulogovan!");
                model.addAttribute("username", "null");
            }
        }catch (Exception e){
            System.out.println("Naisao sam na gresku!");
        }
        return "prijavljeni_kandidati";
    }
}


@Getter
@AllArgsConstructor
@ToString
class pomocna {
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String telefon;
    private String bio;
}
