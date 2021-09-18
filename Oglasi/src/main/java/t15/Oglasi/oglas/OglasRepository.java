package t15.Oglasi.oglas;

import org.springframework.data.domain.Page;
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

    //ime
    @Query(value = "SELECT * FROM oglas a WHERE a.name LIKE %?1%", nativeQuery = true)
    public Page<Oglas> findByKeyword(String word, Pageable pageable);

    //mesto
    @Query(value = "SELECT * FROM oglas a WHERE a.mesto LIKE %?1%", nativeQuery = true)
    public Page<Oglas> findByGrad(String grad, Pageable pageable);

    //oblast
    @Query(value = "SELECT o.* FROM oglas o JOIN oblast_tag ot ON o.id = ot.id_oglas JOIN oblast t ON t.id = ot.id_tag WHERE t.naziv LIKE %?1%", nativeQuery = true)
    public Page<Oglas> findByOblast(String oblast, Pageable pageable);

    //ime i mesto
    @Query(value = "SELECT * FROM oglas a WHERE a.name LIKE %?1% AND a.mesto LIKE %?2%", nativeQuery = true)
    public Page<Oglas> findByKeywordAndGrad(String word, String grad, Pageable pageable);

    //ime i oblast
    @Query(value = "SELECT o.* FROM oglas o JOIN oblast_tag ot ON o.id = ot.id_oglas JOIN oblast t ON t.id = ot.id_tag WHERE t.naziv LIKE %?2% AND o.name LIKE %?1%", nativeQuery = true)
    public Page<Oglas> findByKeywordAndOblast(String wordm, String oblast, Pageable pageable);

    //mesto i oblast
    @Query(value = "SELECT o.* FROM oglas o JOIN oblast_tag ot ON o.id = ot.id_oglas JOIN oblast t ON t.id = ot.id_tag WHERE o.mesto LIKE %?1% AND t.naziv LIKE %?2%", nativeQuery = true)
    public Page<Oglas> findByMestoAndOblast(String mesto, String oblast, Pageable pageable);

    //ime i mesto i grad
    @Query(value = "SELECT o.* FROM oglas o JOIN oblast_tag ot ON o.id = ot.id_oglas JOIN oblast t ON t.id = ot.id_tag WHERE o.mesto LIKE %?2% AND t.naziv = %?3% AND o.name LIKE %?1%", nativeQuery = true)
    public Page<Oglas> findByAll(String keyword, String mesto, String oblast, Pageable pageable);

    @Query(value = "SELECT * FROM oglas ORDER BY oglas.postavljen DESC LIMIT 6", nativeQuery = true)
    public List<Oglas> findTop6();
}
