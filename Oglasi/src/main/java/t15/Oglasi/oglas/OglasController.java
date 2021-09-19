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
    public String dodaj(@RequestBody Oglas request)
    {
        oglasService.postaviOglas(request);
        return "uspesno";
    }


}

@RestController
@RequestMapping(value = "/postavioglasp", method = RequestMethod.POST)
@AllArgsConstructor
class OglasControlerPostavi {
    @Autowired
    private OglasService oglasService;

    @PostMapping
    public void saveOglas(Oglas request, @RequestParam("image") MultipartFile multipartFile, HttpServletResponse response) throws IOException
    {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        request.setBaner(fileName);

        Oglas saved = oglasService.postaviOglas(request);
        String uploadDir = "/slike/baneri/" + saved.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        response.sendRedirect("/");
    }
}