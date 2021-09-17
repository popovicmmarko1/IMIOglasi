package t15.Oglasi.oglas;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface OglasRepository extends JpaRepository<Oglas, Long>, PagingAndSortingRepository<Oglas, Long> {

    @Query(value = "SELECT * FROM oglas a WHERE a.name LIKE %?1% ", nativeQuery = true)
    public List<Oglas> findByKeyword(String word, Pageable pageable);



}
