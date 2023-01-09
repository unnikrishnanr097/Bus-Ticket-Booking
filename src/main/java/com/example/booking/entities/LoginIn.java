package com.example.booking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginIn {
    private String email;
    private Long phoneNumber;

    private String username;

    private String password;

    private String firstName;


}
