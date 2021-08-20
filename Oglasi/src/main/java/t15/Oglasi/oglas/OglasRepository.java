package t15.Oglasi.oglas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OglasRepository extends JpaRepository<Oglas, Long> {

}
