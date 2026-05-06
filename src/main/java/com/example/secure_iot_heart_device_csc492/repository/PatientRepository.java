// Ryan Chavez
// CSC 492 - User Repository: checks for user


package com.example.secure_iot_heart_device_csc492.repository;

import com.example.secure_iot_heart_device_csc492.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByPatientId(String patientId);


}
