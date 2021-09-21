package t15.Oglasi.appUser.user.profil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ProfilRepository extends JpaRepository<Profil, Long> {

    @Query(value = "SELECT * FROM profil p WHERE p.app_user_id = ?1", nativeQuery = true)
    Profil findByAppUserId(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Profil p SET p.opis = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    public void updateBio(String bio, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Profil p SET p.br_telefona = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    public void updateTelefon(String telefon, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Profil p SET p.mesto = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    public void updateMesto(String mesto, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Profil p SET p.slika = ?1 WHERE p.app_user_id = ?2", nativeQuery = true)
    void updateSlika(String slikap, Long id);
}
