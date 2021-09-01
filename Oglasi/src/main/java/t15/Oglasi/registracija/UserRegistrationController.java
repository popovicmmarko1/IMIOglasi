package t15.Oglasi.registracija;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final RegistrationService registrationService;

    @PostMapping()
    public void register(RegistrationRequest request, HttpServletResponse response) throws IOException {
        registrationService.register(request);
        response.sendRedirect("/login");
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token)
    {
        return registrationService.confirmToken(token);
    }
}
