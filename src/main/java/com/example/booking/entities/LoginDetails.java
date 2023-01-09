package com.example.booking.entities;

import lombok.Data;

@Data
public class LoginDetails {
    private String email;
    private Long phoneNumber;

    private String username;
    private String firstName;

    private String lastName;

    private String gender;


}
