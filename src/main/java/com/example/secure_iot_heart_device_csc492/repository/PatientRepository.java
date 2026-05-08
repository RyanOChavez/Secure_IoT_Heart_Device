// Ryan Chavez
//Patient Repository: Stores patient data


package com.example.secure_iot_heart_device_csc492.repository;

import com.example.secure_iot_heart_device_csc492.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {

}
