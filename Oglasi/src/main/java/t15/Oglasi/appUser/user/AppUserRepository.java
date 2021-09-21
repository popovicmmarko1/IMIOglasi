package t15.Oglasi.appUser.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = "SELECT * FROM app_user a WHERE a.email = ?1", nativeQuery = true)
    Optional<AppUser> findByEmail1(String email);

    @Query(value = "SELECT * FROM app_user a WHERE a.id = ?1", nativeQuery = true)
    AppUser findById1(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);


    @Transactional
    @Modifying
    @Query(value = "UPDATE App_User a SET a.f_name = ?1 WHERE a.id = ?2", nativeQuery = true)
    public void updateIme(String ime, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE App_User a SET a.l_name = ?1 WHERE a.id = ?2", nativeQuery = true)
    public void updatePrezime(String prezime, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE App_User a SET a.f_name = ?1 WHERE a.id = ?2", nativeQuery = true)
    public void updateBio(String prezime, Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE App_User a SET a.email = ?1 WHERE a.id = ?2", nativeQuery = true)
    public void updateEmail(String email, Long id);

    AppUser findByEmail(String s);
}
