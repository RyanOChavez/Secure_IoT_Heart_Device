// Ryan Chavez
// CSC 492 - Home Controller: Provides a root endpoint so the browser has a landing page with available API routes

package com.example.secure_iot_heart_device_csc492.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class Home {

    @GetMapping
    public ResponseEntity<Map<String, Object>> home() {
        return ResponseEntity.ok(Map.of(
                "app", "Secure IoT Heart Device",
                "endpoints", Map.of(
                        "GET /api/patients",        "List all patients (DOCTOR)",
                        "POST /api/device/data",    "Receive IoT device data (no auth required)",
                        "GET /h2-console",          "H2 database console (no auth required)"
                )
        ));
    }

}
