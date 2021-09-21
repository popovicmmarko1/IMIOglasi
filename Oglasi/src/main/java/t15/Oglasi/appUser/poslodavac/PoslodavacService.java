package t15.Oglasi.appUser.poslodavac;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PoslodavacService {

    @Autowired
    private final PoslodavacRepository poslodavacRepository;

    public void updateNaziv(String naziv, Long id) {
        poslodavacRepository.promeniNaziv(naziv, id);
    }

    public void updateGrad(String grad, Long id) {
        poslodavacRepository.promeniGrad(grad, id);
    }

    public void updateEmail(String email, Long id) {
        poslodavacRepository.promeniEmail(email, id);
    }

    public void updateOpis(String opis, Long id) {
        poslodavacRepository.promeniOpis(opis, id);
    }

    public void updateTelefon(String telefon, Long id) {
        poslodavacRepository.promeniTelefon(telefon, id);
    }

    public void updateMesto(String adresa, Long id) {
        poslodavacRepository.promeniAdresa(adresa, id);
    }

    public void updateBaner(String baner, Long id){
        poslodavacRepository.promeniBaner(baner, id);
    }

    public void updateLogo(String logo, Long id) {
        poslodavacRepository.promeniLogo(logo, id);
    }

    public void obirsiPoslodavca(Long id){
        poslodavacRepository.delete(poslodavacRepository.getById(id));
    }
}
