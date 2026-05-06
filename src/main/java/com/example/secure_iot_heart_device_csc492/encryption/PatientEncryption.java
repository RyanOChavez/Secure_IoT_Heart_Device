package com.example.secure_iot_heart_device_csc492.encryption;

import com.example.secure_iot_heart_device_csc492.Model.Patient;
import com.example.secure_iot_heart_device_csc492.repository.PatientRepository;
import com.example.secure_iot_heart_device_csc492.requests.HistoryRequest;
import com.example.secure_iot_heart_device_csc492.requests.PatientRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientEncryption {

    private static final Logger logger = LoggerFactory.getLogger(PatientEncryption.class);

    private final PatientRepository repository;
    private final AesEncryption encryptionService;

    public PatientEncryption(PatientRepository repository, AesEncryption encryptionService) {
        this.repository = repository;
        this.encryptionService = encryptionService;
    }

    public void receiveDeviceData(HistoryRequest request) {
        try {
            //int heartRate = Integer.parseInt(encryptionService.decrypt(request.encryptedHeartRate()));
            //double temp = Double.parseDouble(encryptionService.decrypt(request.encryptedTemp()));
            int heartRate = Integer.parseInt(request.encryptedHeartRate());
            double temp = Double.parseDouble((request.encryptedTemp()));
            String encryptedDeviceId = encryptionService.encrypt(request.deviceId());

            Patient patient = new Patient(
                    request.patientId(),
                    request.deviceId(),
                    encryptedDeviceId,
                    request.encryptedTemp(),
                    heartRate,
                    temp
            );
            repository.save(patient);
        } catch (Exception e) {
            logger.error("Failed to process device data for patient {}: {}", request.patientId(), e.getMessage());
            throw new RuntimeException("Decryption failed", e);
        }
    }

    public List<PatientRequest> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public List<PatientRequest> findByPatientId(String patientId) {
        return repository.findByPatientId(patientId).stream()
                .map(this::toResponse)
                .toList();
    }

    private PatientRequest toResponse(Patient p) {
        return new PatientRequest(p.getId(), p.getPatientId(), p.getDeviceId(), p.getHeartRate(), p.getTemp(), p.getCreated());
    }
}

