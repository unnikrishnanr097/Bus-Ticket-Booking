package com.example.booking.controller;

import com.example.booking.entities.LoginDetails;
import com.example.booking.entities.LoginIn;
import com.example.booking.entities.Registration;
import com.example.booking.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody Registration registration) {

        return registrationService.addUser(registration);
    }

    @GetMapping("/login")
    public Optional<LoginDetails> login(@RequestBody LoginIn loginIn) {

        return registrationService.login(loginIn);
    }
}
