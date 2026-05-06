package com.example.secure_iot_heart_device_csc492.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFormat {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // allow H2 console iframe
                .authorizeHttpRequests(auth -> auth
                        // IoT devices post encrypted data without user credentials
                        .requestMatchers(HttpMethod.POST, "/api/device/**").permitAll()
                        // H2 console for development inspection
                        .requestMatchers("/h2-console/**").permitAll()
                        // Patient data: both roles can read
                        .requestMatchers(HttpMethod.GET, "/api/patients/**").hasRole("DOCTOR").anyRequest().authenticated()

                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
