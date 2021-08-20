package t15.Oglasi.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("Select a from Tag a where a.idOglasa = ?1")
    List<Tag> findByOglasId(Long id);
}
