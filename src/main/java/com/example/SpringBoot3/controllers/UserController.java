package com.example.SpringBoot3.controllers;


import com.example.SpringBoot3.dto.LoginDTO;
import com.example.SpringBoot3.dto.MailDTO;
import com.example.SpringBoot3.dto.MessageDTO;
import com.example.SpringBoot3.dto.AuthUserDTO;
import com.example.SpringBoot3.services.AuthenticationService;
import com.example.SpringBoot3.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    EmailService emailService;
    AuthenticationService authenticationService;

    public UserController(EmailService emailService, AuthenticationService authenticationService) {
        this.emailService = emailService;
        this.authenticationService = authenticationService;
    }

    //UC9 --> For Registration of a user
    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user) {
        return authenticationService.register(user);
    }


    //UC10 --> For User Login
    @PostMapping(path ="/login")
    public String login(@RequestBody LoginDTO user){
        return authenticationService.login(user);
    }

    //UC11 --> For sending mail to another person
    @PostMapping(path = "/sendMail")
    public String sendMail(@RequestBody MailDTO message){
        emailService.sendEmail(message.getTo(), message.getSubject(), message.getBody());
        return "Mail sent";
    }

}
