package t15.Oglasi.pageControllers.Oglas;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import t15.Oglasi.oglas.Oglas;
import t15.Oglasi.oglas.OglasService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/postavioglas", method = RequestMethod.POST)
@AllArgsConstructor
public class DodajOglasController {
    @Autowired
    private OglasService oglasService;



    @PostMapping
    public String saveOglas(Oglas request, @RequestParam("image") MultipartFile file, HttpServletResponse response) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        request.setBaner(fileName);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        request.setPostavljen(LocalDateTime.now().format(df));

        String dir = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\slike\\baneri\\" + request.getId() + "\\";

        DodajOglasController.saveFile(dir, fileName, file);
        Oglas saved = oglasService.postaviOglas(request);



        response.sendRedirect("/");
        return "Uspesno postavljen oglas";
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