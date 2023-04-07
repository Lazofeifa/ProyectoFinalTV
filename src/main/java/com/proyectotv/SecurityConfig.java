package com.proyectotv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                        "/",
                        "/index",
                        "/info/**",
                        "/errores/**",
                        "/webjars/**").permitAll()
                .requestMatchers(
                        "/producto/**",
                        "/comentario/**",
                        "/suscripcion/**").hasAnyRole("ADMIN", "VENDEDOR")
                .requestMatchers(
                        "/cliente/**").hasRole("ADMIN")
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/errores/403");
        return http.build();
    }
}
