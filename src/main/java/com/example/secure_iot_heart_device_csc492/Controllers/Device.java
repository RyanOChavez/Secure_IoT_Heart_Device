// Ryan Chavez
// Device - recieves patient data through the api. Sends heart rate and temperture to the backend system


package com.example.secure_iot_heart_device_csc492.Controllers;
import com.example.secure_iot_heart_device_csc492.encryption.PatientEncryption;
import com.example.secure_iot_heart_device_csc492.requests.DataRequest;
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
    // Data is recieved from the IoT device.
    @PostMapping("/data")
    public ResponseEntity<Map<String, String>> receiveData(@RequestBody DataRequest request) {
        patientEncryption.receiveDeviceData(request); // data is sento to encrypt
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Encrypted data received and stored for patient " + request.patientId() // message is sent if there is a successful transfer of data
        ));
    }



}
