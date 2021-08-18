package t15.Oglasi.poslodavac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PoslodavacRepository extends JpaRepository<Poslodavac, Long> {

}
