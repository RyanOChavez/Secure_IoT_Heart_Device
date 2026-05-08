// Ryan Chavez
// SecurityFormat: Allows for Spring Securty to be used. The doctor account is created with a username and password.

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
        http.csrf(csrf -> csrf.disable()).headers(headers -> headers.frameOptions(frame -> frame.disable())) // allow H2 console iframe
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/device/**").permitAll().requestMatchers("/h2-console/**").permitAll() // IoT device is allowed to dtore data without log information
                        .requestMatchers(HttpMethod.GET, "/api/patients/**").hasRole("DOCTOR"). // Doctors could only access patient records
                        anyRequest().authenticated() // doctor must log in
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
