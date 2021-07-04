package com.example.springSecurity.Security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam("name")String name,@RequestParam("age")int age){

        return User.builder()
                .name(name)
                .age(age)
                .admin(false)
                .build();
    }

    @GetMapping("/admin")
    public User getAdmin(@RequestParam("name")String name,@RequestParam("age")int age){

        return User.builder()
                .name(name)
                .age(age)
                .admin(true)
                .build();
    }

    @GetMapping("/")
    public String welcome(){
        return "Welcome to Home Page!!";
    }



}
