package com.example.booking.service;

import com.example.booking.entities.LoginDetails;
import com.example.booking.entities.LoginIn;
import com.example.booking.entities.Registration;
import com.example.booking.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class RegistrationService {
    @Autowired
    RegistrationRepo registrationRepo;
    @Autowired
    MailSender mailSender;

    @Transactional
    public String addUser(Registration registration) {
        int id = (int) registrationRepo.count();
        registration.setId(++id);
        if (registration.getEmail().isEmpty() || registration.getGender().isEmpty() || registration.getFirstName().isEmpty() || registration.getPhoneNumber() == null || registration.getPassword().isEmpty()) {
            throw new RuntimeException("Data Missing");
        }
        if (registration.getPhoneNumber().toString().length() != 10) {
            throw new RuntimeException("Invalid Phone Number");
        }
        if ((registration.getPassword().length() < 8)) {
            throw new RuntimeException("Password too short");
        }
/*
        try {
            mailSender.sendmail(registration.getEmail());
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
*/
        registrationRepo.save(registration);
        return "success";
    }

    public Optional<LoginDetails> login(LoginIn loginIn) {
        return registrationRepo.findByEmailOrPhoneNumberAndPassword(loginIn.getEmail(),loginIn.getPhoneNumber(), loginIn.getPassword());
    }
}
