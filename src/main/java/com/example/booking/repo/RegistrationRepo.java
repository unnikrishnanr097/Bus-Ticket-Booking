package com.example.booking.repo;

import com.example.booking.entities.LoginDetails;
import com.example.booking.entities.LoginIn;
import com.example.booking.entities.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RegistrationRepo extends MongoRepository<Registration,Integer> {
//     @Query("{email:?0,phoneNumber:?1,password:?3}")
//     Optional<LoginDetails> findUser(LoginIn login);

     Optional<LoginDetails> findByEmailOrPhoneNumberAndPassword(String email, @Param("phoneNumber") Long phoneNumber, String password);

}
