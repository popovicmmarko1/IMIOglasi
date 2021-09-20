package t15.Oglasi.oglas.prijava;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OglasPrijavaService {

    @Autowired
    private final OglasPrijavaRepository oglasPrijavaRepository;

    public OglasPrijava save(OglasPrijava request)
    {
        return oglasPrijavaRepository.save(request);
    }

    public boolean proveri(OglasPrijava request)
    {
        if(oglasPrijavaRepository.proveri(request.getIdOglasa(), request.getIdKorisnika()).isPresent())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
