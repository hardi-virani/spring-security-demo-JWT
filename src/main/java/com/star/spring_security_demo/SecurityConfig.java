package com.star.spring_security_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    private UserDetails User;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable())
                        .authorizeHttpRequests(request -> request
                                .requestMatchers("/register")
                                .permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.httpBasic(Customizer.withDefaults()).sessionManagement(session ->

                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        );

        return http.build();

    }


    @Autowired
    private UserDetailsService userDetailsService;



    @Bean
    public AuthenticationProvider authProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;

    }
}

// This is when the new user can access our regiter endpoint and register for the first time by themselves in mydb users table db.
// first user
//id = 1
//username = hardi
//password = h@12
