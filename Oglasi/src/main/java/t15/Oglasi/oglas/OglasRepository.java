package t15.Oglasi.oglas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface OglasRepository extends JpaRepository<Oglas, Long>, JpaSpecificationExecutor<Oglas> {

    @Query(value = "SELECT * FROM oglas ORDER BY oglas.postavljen DESC LIMIT 6", nativeQuery = true)
    public List<Oglas> findTop6();

    public Page<Oglas> findAll(Specification<Oglas> oglasSpecification, Pageable pageable);

}
