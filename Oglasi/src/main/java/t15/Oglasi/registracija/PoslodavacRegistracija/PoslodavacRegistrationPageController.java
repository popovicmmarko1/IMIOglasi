package t15.Oglasi.registracija.PoslodavacRegistracija;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoslodavacRegistrationPageController {
    @GetMapping(value = {"/signup_poslodavac",  "/signup_poslodavac.html"})
    public String signup_poslodavac()
    {
        return "signup_poslodavac";
    }
}
