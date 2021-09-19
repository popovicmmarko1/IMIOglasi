package t15.Oglasi.oglas;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import t15.Oglasi.slike.FileUploadUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/postavioglas", method = RequestMethod.POST)
@AllArgsConstructor
public class OglasController {
    @Autowired
    private OglasService oglasService;

    @PostMapping
    public String saveOglas(Oglas request, @RequestParam("image") MultipartFile file, HttpServletResponse response) throws Exception
    {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        request.setBaner(fileName);

        Oglas saved = oglasService.postaviOglas(request);
        String uploadDir = "\\META-INF.resources\\static\\slike\\baneri\\" + saved.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        response.sendRedirect("/");
        return "Uspesno postavljen oglas";
    }
}