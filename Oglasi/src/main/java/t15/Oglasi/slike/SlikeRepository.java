package t15.Oglasi.slike;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SlikeRepository extends JpaRepository<Slike, Long> {

    @Query("SELECT a from Slike a where a.idOglasa = ?1")
    List<Slike> findByOglasId(Long id);
}
