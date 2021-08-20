package t15.Oglasi.appUser.expirience;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpirienceRepository extends JpaRepository<Expirience, Long> {

    Expirience findByAppUserId(Long id);
}
