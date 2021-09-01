package t15.Oglasi.oglas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OglasRepository extends JpaRepository<Oglas, Long> {

    @Query("select distinct(mesto) from Oglas order by mesto")
    Oglas dajMesta();

}
