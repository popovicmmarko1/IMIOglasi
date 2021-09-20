package t15.Oglasi.oglas.prijava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OglasPrijavaRepository extends JpaRepository<OglasPrijava, Long> {



    @Query(value = "SELECT * FROM oglas_prijava op WHERE op.id_oglasa = ?1 AND op.id_korisnika = ?2", nativeQuery = true)
    public Optional<OglasPrijava> proveri(Long oglasId, Long userId);


    @Query(value = "SELECT op.id_korisnika FROM oglas_prijava op WHERE op.id_oglasa = ?1", nativeQuery = true)
    public List<Long> findByOglasId(Long id);


}
