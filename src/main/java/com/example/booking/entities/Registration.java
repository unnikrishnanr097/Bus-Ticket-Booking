package com.example.booking.entities;

import jakarta.validation.constraints.Email;
import lombok.Data;


@Data
public class Registration {
    private int id;

    private String firstName;

    private String lastname;

    private String gender;
    @Email
    private String email;

    private Long phoneNumber;

    private String username;

    private String password;

}
