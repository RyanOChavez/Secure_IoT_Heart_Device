package com.example.secure_iot_heart_device_csc492.Controllers;
import com.example.secure_iot_heart_device_csc492.encryption.PatientEncryption;
import com.example.secure_iot_heart_device_csc492.requests.PatientRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/patients")
public class PatientDevice {
    private final PatientEncryption patientEncryption;

    public PatientDevice(PatientEncryption patientEncryption ) {
        this.patientEncryption = patientEncryption;

    }

    @GetMapping
    public ResponseEntity<List<PatientRequest>> getAllPatients(Authentication auth) {

        return ResponseEntity.ok(patientEncryption.findAll());
    }

}
