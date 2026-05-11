// Ryan Chavez
// Home - Provides a root endpoint for the browser to have a landing page

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
