package t15.Oglasi.pageControllers.SingleControllerPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;
import t15.Oglasi.oglas.Oglas;
import t15.Oglasi.oglas.OglasRepository;
import t15.Oglasi.oglas.OglasService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ListingController {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    OglasService oglasService;

    @GetMapping(value = {"listing",  "/listing.html"})
    public String pretraga(@RequestParam Optional<Integer> page, @RequestParam Optional<String> search, @RequestParam Optional<String> grad,
                           @RequestParam Optional<String> oblast, @RequestParam Optional<String> obrazovanje, @RequestParam Optional<String> ri,
                           @RequestParam Optional<String> tip, @RequestParam Optional<String> pol, @RequestParam Optional<String> rv,
                           Model model, Principal principal)
    {
        try{
            Optional<AppUser> ulogovan = appUserRepository.findByEmail1(principal.getName());
            if(ulogovan.isPresent())
            {
                model.addAttribute("username",ulogovan.get().getFName());
            }
        }catch (Exception e) {
            System.out.println("Nije ulogovan!");
        }

        String search1 = search.orElse(null);
        String grad1 = grad.orElse(null);
        String oblast1 = oblast.orElse(null);
        String obrazovanje1 = obrazovanje.orElse(null);
        String ri1 = ri.orElse(null);
        String tip1 = tip.orElse(null);
        String pol1 = pol.orElse(null);
        String rv1 = rv.orElse(null);

        Page<Oglas> oglasi = oglasService.findByPagingCriteria(search1, grad1, oblast1, obrazovanje1, ri1, tip1, pol1, rv1, PageRequest.of(page.orElse(0), 6));
        model.addAttribute("oglasi", oglasi);
        model.addAttribute("nop", oglasi.getTotalPages());
        model.addAttribute("noe",oglasi.getTotalElements());

        return "listing";
    }
}
