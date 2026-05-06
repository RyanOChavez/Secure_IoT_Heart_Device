// Ryan Chavez
// CSC 492 Histroy: Stores all recorded data from the user and or doctor/nurse

package com.example.secure_iot_heart_device_csc492.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String action;

    @Column(length = 512)
    private String message;

    private LocalDateTime record;

    public History() { //default cosntrcutor

    }
    public History(String username, String action, String message) { // constructor
        this.username = username;
        this.action = action;
        this.message = message;
        this.record = LocalDateTime.now();

    }
    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getAction() {
        return action;
    }
    public String getMessage() {
        return message;
    }
    public LocalDateTime getRecord() {
        return record;
    }

}
