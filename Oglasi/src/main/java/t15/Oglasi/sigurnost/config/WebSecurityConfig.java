package t15.Oglasi.sigurnost.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import t15.Oglasi.appUser.user.AppUserService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/registration/**", "/signup/**").permitAll()
                .antMatchers( "/registrationp/**", "/signup_poslodavac/**").permitAll()
                .antMatchers("/assets/**", "/css/**", "/Doc/**", "/fonts/**", "/images/**","/js/**","/slike/**", "/vendor/**").permitAll()
                .antMatchers( "/",  "/_layout/**","/blog/**", "/blog_details/**","/contact/**", "/directory_details/**","/elements/**",
                        "/employers/**", "/index/**", "/listing/**", "/login/**","/oglas/**", "/prijavljeni_kandidati/**", "/admin_korisnici/**", "/admin_oglasi/**", "/admin_poslodavci/**").permitAll()

                .antMatchers("/profil/**").hasAnyAuthority("PUSER","USER")

                .antMatchers("/postavioglas/**", "/dodaj_oglas/**","/objavljeni_poslovi/**", "/profil_poslodavac/**", "/profilpromenap/**").hasAuthority("PUSER")

                .antMatchers("/admin_korisnici/**", "/admin_oglasi/**", "/admin_poslodavci/**").hasAuthority("ADMIN")

                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/")
                .usernameParameter("email").passwordParameter("password").permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider())
                .inMemoryAuthentication().withUser("admin@admin.com").password(bCryptPasswordEncoder.encode("admin")).authorities("ADMIN");;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }



}
