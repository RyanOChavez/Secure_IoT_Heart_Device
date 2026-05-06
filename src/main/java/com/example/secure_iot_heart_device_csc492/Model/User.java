// Ryan Chavez
// CSC 492 - User Class : Handles and stores log in information. User depending on the role must enter a id number, password, and role based on if they are a patient, nurse, or doctor


package com.example.secure_iot_heart_device_csc492.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id number from the patient
    private long id;

    @Column(unique = true, nullable = false) // checks if a user name is entered
    private String username;

    @Column(nullable = false) // check is password is entered
    private String password;

    @Column(nullable = false) // check for role
    private String role;

    public User() { // default constructor

    }

    public User(String username, String password, String role) { // constructor
        this.username = username;
        this.password = password;
        this.role = role;
    }
    // getters
    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }


}
