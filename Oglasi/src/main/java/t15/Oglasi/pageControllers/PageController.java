package t15.Oglasi.pageControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.appUser.user.profil.Profil;
import t15.Oglasi.appUser.user.profil.ProfilRepository;
import t15.Oglasi.grad.GradRepository;
import t15.Oglasi.oglas.OglasRepository;
import t15.Oglasi.oglas.OglasService;
import t15.Oglasi.appUser.poslodavac.PoslodavacRepository;
import t15.Oglasi.slike.SlikeRepository;
import t15.Oglasi.tag.oblast.OblastRepository;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class PageController {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private OglasRepository oglasRepository;
    @Autowired
    private OglasService oglasService;
    @Autowired
    private SlikeRepository slikeRepository;
    @Autowired
    private PoslodavacRepository poslodavacRepository;
    @Autowired
    private ProfilRepository profilRepository;
    @Autowired
    private GradRepository gradRepository;
    @Autowired
    private OblastRepository oblastRepository;

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping(value = {"/signup",  "/signup.html"})
    public String signup()
    {
        return "signup";
    }

    @GetMapping(value = {"/signup_poslodavac",  "/signup_poslodavac.html"})
    public String signup_poslodavac()
    {
        return "signup_poslodavac";
    }

    @GetMapping(value = {"oglas",  "/oglas.html"})
    public String oglas()
    {
        return "oglas";
    }

    @GetMapping(value = {"prijavljeni_kandidati",  "/prijavljeni_kandidati.html"})
    public String prijavljeni_kandidati()
    {
        return "prijavljeni_kandidati";
    }

    @GetMapping(value = {"employers",  "/employers.html"})
    public String employers(Model model, Principal principal)
    {
        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }

        model.addAttribute("naziv", "Poslodavac1");
        model.addAttribute("opis", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras facilisis elit mi, vel imperdiet metus condimentum ac. Suspendisse ut efficitur sem, dapibus dapibus urna. Vestibulum ante ipsum ");
        model.addAttribute("baner", "data:image/jpeg;base64,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");
        model.addAttribute("logo", "https://seeklogo.com/images/C/coca-cola-circle-logo-A9EBD3B00A-seeklogo.com.png");
        return "employers";
    }

    @GetMapping(value = {"blog",  "/blog.html"})
    public String blog(Model model, Principal principal)
    {
        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }

        return "blog";
    }

    @GetMapping(value = {"blog_details",  "/blog_details.html"})
    public String blog_details()
    {
        return "blog_details";
    }

    @GetMapping(value = {"contact",  "/contact.html"})
    public String contact(Model model, Principal principal)
    {
        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
            }
        }catch (Exception e){
            System.out.println("Nije ulogovan!");
        }

        return "contact";
    }

    @GetMapping(value = {"directory_details",  "/directory_details.html"})
    public String directory_details()
    {
        return "directory_details";
    }

    @GetMapping(value = {"_layout",  "/_layout.html"})
    public String layout()
    {
        return "_layout";
    }

    @GetMapping(value = {"elements",  "/elements.html"})
    public String elements()
    {
        return "elements";
    }

    @GetMapping(value = {"dodaj_oglas",  "/dodaj_oglas.html"})
    public String dodaj_oglas()
    {
        return "dodaj_oglas";
    }

    @GetMapping(value = {"profil",  "/profil.html"})
    public String profil(Model model)
    {
        model.addAttribute("ime", "ime1");
        model.addAttribute("prezmi", "prezime1");
        model.addAttribute("mesto", "mesto1");
        model.addAttribute("bio", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras facilisis elit mi, vel imperdiet metus condimentum ac. Suspendisse ut efficitur sem, dapibus dapibus urna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Pellentesque sagittis mattis arcu, vitae dictum risus tristique sed. Donec nec dictum orci. Pellentesque malesuada nulla sem. Sed eu nisi nec felis cursus ultricies at in lacus. Nulla id est a nisi mattis rutrum. Integer ipsum turpis, fringilla vel pulvinar in, mollis ut tortor.");
        model.addAttribute("email", "email@email.com");
        model.addAttribute("telefon", "065065065");
        return "profil";
    }

    @GetMapping(value = {"profil_cela_strana",  "/profil.html"})
    public String profil_cela_strana(Model model)
    {
        return "profil_cela_strana";
    }

    @GetMapping(value = {"myprofile"})
    public String profilTest(Model model, Principal principal)
    {
        AppUser user;
        Profil profil;
        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail(principal.getName());
            if(ulogovan.isPresent())
            {
                user = ulogovan.get();
                profil = profilRepository.findByAppUserId(user.getId());
                model.addAttribute("username",user.getFName());
                model.addAttribute("ime", user.getFName());
                model.addAttribute("prezime", user.getLName());
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


    @GetMapping("/oglas_create")
    public String napraviOglas() { return "oglas_create"; }



    @GetMapping("/oglas/test")
    public String test(Model model)
    {
        model.addAttribute("naslov", "Posao 1");
        model.addAttribute("mesto", "Mesto 1");
        model.addAttribute("postavljen", LocalDateTime.now().toString());
        model.addAttribute("istice", LocalDateTime.now().plusDays(20).toString());
        model.addAttribute("poslodavac", "Poslodavac 1");
        model.addAttribute("opis", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        model.addAttribute("poslodavac_opis", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
        return "oglas";
    }
}
