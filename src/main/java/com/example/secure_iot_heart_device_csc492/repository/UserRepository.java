// Ryan Chavez
// CSC 492 - Saves data from in the IoT device

package com.example.secure_iot_heart_device_csc492.repository;

import com.example.secure_iot_heart_device_csc492.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
