// Ryan Chavez
// CSC 492 - Data Initializer: Seeds default doctor and nurse accounts on startup

package com.example.secure_iot_heart_device_csc492;

import com.example.secure_iot_heart_device_csc492.Model.User;
import com.example.secure_iot_heart_device_csc492.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DataInitializer implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (userRepository.count() > 0) return;

        userRepository.save(new User("doctorroc", passwordEncoder.encode("abc123"), "Doctor"));


        log.info("Created users: doctorroc (Doctor)");
    }
}
