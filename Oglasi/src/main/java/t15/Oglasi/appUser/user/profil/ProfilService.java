package t15.Oglasi.appUser.user.profil;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfilService {

    @Autowired
    private ProfilRepository profilRepository;

    public void updateBio(String bio, Long id)
    {
        profilRepository.updateBio(bio, id);
    }

    public void updateTelefon(String telefon, Long id)
    {
        profilRepository.updateTelefon(telefon, id);
    }

    public void updateMesto(String mesto, Long id)
    {
        profilRepository.updateMesto(mesto, id);
    }


    public void updateSlika(String slikap, Long id) {
        profilRepository.updateSlika(slikap, id);
    }
}
