package com.example.SpringBoot3.controllers;


import com.example.SpringBoot3.dto.MessageDTO;
import com.example.SpringBoot3.services.GreetingService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greetings")
public class GreetingController {

    GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    //UC1

    @GetMapping("/get")
        public String getGreetings(){
            return "{\"message\": \"Hello from GET Request!\"}";
        }

        @PostMapping("/post")
        public String postGreetings(@RequestBody MessageDTO message){
            return "{\""+message.getMessage()+": \"Hello from POST Request!\"}";
        }

        @PutMapping("/put/{message}")
        public String putGreetings(@PathVariable String message){
            return "{\""+message+": \"Hello from PUT Request!\"}";
        }

        //UC2

        @GetMapping("/service")
        public String serviceGreetings(){
            return greetingService.getGreetings();
        }

        //UC3
        @GetMapping("/query")
        public String query(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName){
            if(firstName != null && lastName != null)
                return "Hello "+firstName+" "+lastName+" Welcome to Bridgelabz";
            else if(firstName != null)
                return "Hello "+firstName+" Welcome to Bridgelabz";
            else if(lastName != null)
                return "Hello "+lastName+" Welcome to Bridgelabz";
            else
                return "Hello, Welcome to Bridgelabz";
        }

}
