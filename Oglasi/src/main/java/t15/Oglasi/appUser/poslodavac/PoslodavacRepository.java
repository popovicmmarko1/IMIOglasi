package t15.Oglasi.appUser.poslodavac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PoslodavacRepository extends JpaRepository<Poslodavac, Long> {

    @Query(value="select * from poslodavac p where p.app_user_id = ?1", nativeQuery = true)
    public Optional<Poslodavac> findByID(Long id);

}
