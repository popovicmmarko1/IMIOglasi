package t15.Oglasi.pageControllers.profil;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import t15.Oglasi.appUser.poslodavac.PoslodavacPromena;
import t15.Oglasi.appUser.poslodavac.PoslodavacService;
import t15.Oglasi.appUser.user.AppUserService;
import t15.Oglasi.appUser.user.profil.ProfilService;
import t15.Oglasi.pageControllers.Oglas.DodajOglasController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@RestController
@RequestMapping(value = "/profilpromenap", method = RequestMethod.POST)
@AllArgsConstructor
public class PoslodavacPromenaController {
    @Autowired
    private PoslodavacService poslodavacService;
    @PostMapping
    public String promeniProfil(PoslodavacPromena request, @RequestParam(name = "baner", required = false) MultipartFile baner,
                                @RequestParam(name = "logo", required = false) MultipartFile logo, HttpServletResponse response) throws IOException {
        Long id = request.getId();
        System.out.println(request);
        if(!request.getNaziv().equals("")) { poslodavacService.updateNaziv(request.getNaziv(), id); }
        if(!request.getGrad().equals("")) {  poslodavacService.updateGrad(request.getGrad(), id); }
        if(!request.getEmail().equals("")) {
            poslodavacService.updateEmail(request.getEmail(), id);
            response.sendRedirect("/logout");
            return "OK";
        }
        if(!request.getOpis().equals("")) { poslodavacService.updateOpis(request.getOpis(), id); }
        if(!request.getTelefon().equals("")) { poslodavacService.updateTelefon(request.getTelefon(), id); }
        if(!request.getAdresa().equals("")) { poslodavacService.updateMesto(request.getAdresa(), id); }
        if(!baner.isEmpty())
        {
            System.out.println("Usao sam ovde");
            String banern = StringUtils.cleanPath(baner.getOriginalFilename());
            poslodavacService.updateBaner(banern, id);
            String dir = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\slike\\baneri\\" + request.getId() + "\\";
            PoslodavacPromenaController.saveFile(dir, banern, baner);

        }
        if(!logo.isEmpty())
        {
            String logol = StringUtils.cleanPath(logo.getOriginalFilename());
            poslodavacService.updateLogo(logol, id);
            String dir = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\slike\\logo\\" + request.getId() + "\\";
            PoslodavacPromenaController.saveFile(dir, logol, logo);
        }
        response.sendRedirect("/profil_poslodavac");
        return "OK";
    }

    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
}
