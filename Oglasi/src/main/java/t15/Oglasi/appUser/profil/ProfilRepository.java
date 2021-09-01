package t15.Oglasi.appUser.profil;

import groovy.transform.TailRecursive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ProfilRepository extends JpaRepository<Profil, Long> {

    @Query("Select a from Profil a where a.AppUserId = ?1")
    Profil findByAppUserId(Long id);
}
