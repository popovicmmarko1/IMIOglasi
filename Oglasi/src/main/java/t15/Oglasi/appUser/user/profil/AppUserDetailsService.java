package t15.Oglasi.appUser.user.profil;

import org.apache.catalina.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import t15.Oglasi.appUser.user.AppUser;
import t15.Oglasi.appUser.user.AppUserRepository;

import java.util.Collection;
import java.util.Set;

public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;
    


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final AppUser appUser = appUserRepository.findByEmail(s);
        if (appUser == null)
        {
            throw new UsernameNotFoundException(s);
        }
        UserDetails user = User.withUsername(appUser.getUsername()).password(appUser.getPassword()).authorities(appUser.getAppUserRole().name()).build();
        return user;
    }


}
