package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static security.applicationRole.student;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApllicationSecurityConfig extends WebSecurityConfigurerAdapter {


     private  final  PasswordEncoder passwordEncoder;
    @Autowired
    public ApllicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/","hello","index.html","/css/*","/js/*")
                .permitAll()
                .antMatchers("/produit/**")
                .hasRole(student.name()).anyRequest()
                .authenticated().and().httpBasic();
    }

    @Override
    protected UserDetailsService userDetailsService() {
       UserDetails karima = User.builder()
               .username("karima")
               .password(passwordEncoder.encode("karima"))
               .roles(student.name()).build();

       UserDetails ka =User.builder().username("ka")
               .password(passwordEncoder.encode("123"))
               .roles(applicationRole.admin.name()).build();

       return  new InMemoryUserDetailsManager(
               karima,
               ka
       );
    }




}

