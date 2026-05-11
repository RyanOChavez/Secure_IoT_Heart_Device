// Ryan Chavez
// Patient Request: Data requests sends information out based on when it is requested

package com.example.secure_iot_heart_device_csc492.requests;

import java.time.LocalDateTime;

// data that is sent out
public record PatientRequest(long id, String patientId, String deviceId, int heartRate, double temp, LocalDateTime timestamp) {

}
