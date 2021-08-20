package t15.Oglasi.oglas;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OglasService {

    @Autowired
    private final OglasRepository oglasRepository;

    public String postaviOglas(Oglas request)
    {
        oglasRepository.save(request);
        return "uspesno";
    }

}
