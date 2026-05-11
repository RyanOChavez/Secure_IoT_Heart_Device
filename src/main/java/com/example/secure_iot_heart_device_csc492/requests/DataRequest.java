// Ryan Chavez
// data Request: Data requests which send information out based on when it is requested

package com.example.secure_iot_heart_device_csc492.requests;

// data that is sent out
public record DataRequest(String patientId, String deviceId, String encryptedHeartRate, String encryptedTemp) {
}
