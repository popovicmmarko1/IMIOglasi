package t15.Oglasi.registracija.UserRegistracija;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegistrationPageController {
    @GetMapping(value = {"/signup",  "/signup.html"})
    public String signup()
    {
        return "signup";
    }
}
