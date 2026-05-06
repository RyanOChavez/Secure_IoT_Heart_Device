package com.example.secure_iot_heart_device_csc492.Controllers;

import com.example.secure_iot_heart_device_csc492.encryption.PatientEncryption;
import com.example.secure_iot_heart_device_csc492.requests.HistoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/device")
public class Device {

    private final PatientEncryption patientEncryption;

    public Device(PatientEncryption patientEncryption) {
        this.patientEncryption = patientEncryption;

    }

    @PostMapping("/data")
    public ResponseEntity<Map<String, String>> receiveData(@RequestBody HistoryRequest request) {
        patientEncryption.receiveDeviceData(request);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Encrypted data received and stored for patient " + request.patientId()
        ));
    }



}
