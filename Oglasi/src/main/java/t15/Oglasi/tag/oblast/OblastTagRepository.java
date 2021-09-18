package t15.Oglasi.tag.oblast;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OblastTagRepository extends JpaRepository<OblastTag, Long> {
}
