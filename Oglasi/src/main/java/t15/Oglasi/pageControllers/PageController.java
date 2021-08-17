package t15.Oglasi.pageControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }


    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

    @GetMapping
    public String landing()
    {
        return "1";
    }
}
