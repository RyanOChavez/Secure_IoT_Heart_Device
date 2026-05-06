// Ryan Chavez
// CSC 492 - Patient Data - In this class the patient data is assigned a generated and recorded. patient, doctor, or nurse is able to use to find their data

package com.example.secure_iot_heart_device_csc492.Model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient")

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generating patient id
    private long id;

    private String patientId;
    private String deviceId;

    @Column(length = 512)
    private String encrytptedDeviceId;

    @Column(length = 512)
    private String encrytptedTemp;

    private int heartRate;
    private double temp;
    private LocalDateTime created;

    public Patient() { // deafult constructor

    }

    public Patient (String patientId, String deviceId, String encrytptedDeviceId, String encrytptedTemp, int heartRate, double temp) { // intilize constructor
        this.patientId = patientId;
        this.deviceId = deviceId;
        this.encrytptedDeviceId = encrytptedDeviceId;
        this.encrytptedTemp = encrytptedTemp;
        this.heartRate = heartRate;
        this.temp = temp;
        this.created = LocalDateTime.now();

    }
    // getters
    public long getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getEncrytptedDeviceId() {
        return encrytptedDeviceId;
    }

    public String getEncrytptedTemp() {
        return encrytptedTemp;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public double getTemp() {
        return temp;
    }

    public LocalDateTime getCreated() {
        return created;
    }

}
