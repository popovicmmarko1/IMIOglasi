package t15.Oglasi.oglas;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


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
