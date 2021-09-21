package t15.Oglasi.appUser.poslodavac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PoslodavacRepository extends JpaRepository<Poslodavac, Long> {

    @Query(value="select * from poslodavac p where p.app_user_id = ?1", nativeQuery = true)
    public Optional<Poslodavac> findByID(Long id);

    @Query(value = "Select * from poslodavac p LIMIT 5", nativeQuery = true)
    public List<Poslodavac> dajPet();

    @Transactional
    @Modifying
    @Query(value = "UPDATE poslodavac p SET p.naziv = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void promeniNaziv(String naziv, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE poslodavac p SET p.grad = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void promeniGrad(String grad, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE poslodavac p SET p.email = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void promeniEmail(String email, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE poslodavac p SET p.opis = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void promeniOpis(String opis, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE poslodavac p SET p.telefon = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void promeniTelefon(String telefon, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE poslodavac p SET p.adresa = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void promeniAdresa(String adresa, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE poslodavac p SET p.baner = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void promeniBaner(String baner, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE poslodavac p SET p.logo = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void promeniLogo(String baner, Long id);
}
