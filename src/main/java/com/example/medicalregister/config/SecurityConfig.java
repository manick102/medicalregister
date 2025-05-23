package com.example.medicalregister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
            )
            .httpBasic(); // For mock auth purpose only
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // This mocks LDAP/Auth0 user
        var user = User.withUsername("manick")
                .password("{noop}password") // {noop} means no encoding for demo
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}