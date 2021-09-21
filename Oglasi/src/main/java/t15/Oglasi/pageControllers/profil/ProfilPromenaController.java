package t15.Oglasi.pageControllers.profil;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import t15.Oglasi.appUser.user.AppUserService;
import t15.Oglasi.appUser.user.profil.ProfilRequest;
import t15.Oglasi.appUser.user.profil.ProfilService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping(value = "/profilpromena", method = RequestMethod.POST)
@AllArgsConstructor
public class ProfilPromenaController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private ProfilService profilService;

    @PostMapping
    public String promeniProfil(ProfilRequest request, @RequestParam("image") MultipartFile slika, HttpServletResponse response) throws IOException {

        Long id = request.getUserId();
        System.out.println(request);
        if(!request.getIme().equals("")) {
            appUserService.updateIme(request.getIme(), id);
        }
        if(!request.getPrezime().equals("")) {
            appUserService.updatePrezime(request.getPrezime(), id);
        }
        if(!request.getEmail().equals("")) {
            appUserService.updateEmail(request.getEmail(), id);
            response.sendRedirect("/logout");
            return "OK";
        }
        if(!request.getBio().equals("")) {
            profilService.updateBio(request.getBio(), id);
        }
        if(!request.getTelefon().equals("")) {
            profilService.updateTelefon(request.getTelefon(), id);
        }
        if(!request.getMesto().equals("")) {
            profilService.updateMesto(request.getMesto(), id);
        }
        if(!slika.isEmpty()){
            String slikap = StringUtils.cleanPath(slika.getOriginalFilename());
            profilService.updateSlika(slikap, id);
            String dir = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\slike\\slika\\" + request.getUserId() + "\\";
            PoslodavacPromenaController.saveFile(dir, slikap, slika);
        }

        response.sendRedirect("/profil");
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
