package com.example.demo.security;

import com.example.demo.filters.JwtRequestFilter;
import com.example.demo.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity

public class ApllicationSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailsService myUserDetailService;
@Autowired
private JwtRequestFilter jwtRequestFilter;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")


                .and().csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll().anyRequest()
                .authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
       public  PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
       }



//************************************************************************************************
        //other way
   /*
     private  final  PasswordEncoder passwordEncoder;
    @Autowired
    public ApllicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/","/hello","index.html","/css/*","/js/*")
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


*/

}

