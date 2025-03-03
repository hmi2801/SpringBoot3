package com.example.SpringBoot3.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    String message;

    GreetingService(){
        message = "Hello World!";
    }

    public String getGreetings(){
        return this.message;
    }

}
