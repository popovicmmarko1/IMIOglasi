package t15.Oglasi.appUser.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import t15.Oglasi.registracija.token.ConfirmationToken;
import t15.Oglasi.registracija.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with email %s not found!";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;


    public String signUser(AppUser appUser)
    {
        boolean userExists = appUserRepository.findByEmail1(appUser.getEmail()).isPresent();

        if(userExists)
        {
            throw new IllegalStateException("Email taken!");
        }
        System.out.println(appUser.getEmail());
        String encodedPass = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPass);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public Optional<AppUser> findUser(String email)
    {
        return appUserRepository.findByEmail1(email);
    }

    public int enableAppUser(String email)
    {
        return appUserRepository.enableAppUser(email);
    }

    public void updateIme(String ime, Long id)
    {
        appUserRepository.updateIme(ime, id);
    }

    public void updatePrezime(String prezime, Long id) {
        appUserRepository.updatePrezime(prezime, id);
    }

    public void updateEmail(String email, Long id)
    {
        appUserRepository.updateEmail(email, id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final AppUser appUser = appUserRepository.findByEmail(s);
        if (appUser == null)
        {
            throw new UsernameNotFoundException(s);
        }
        UserDetails user = User.withUsername(appUser.getUsername()).password(appUser.getPassword()).authorities(appUser.getAppUserRole().name()).build();
        System.out.println("Ima on svoje nesto " + user.getAuthorities());
        return user;
    }

    public void obrisiUser(Long id)
    {
        appUserRepository.delete(appUserRepository.getById(id));
    }
}
