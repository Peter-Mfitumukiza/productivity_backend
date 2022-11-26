package com.example.productivity.controllers;

import com.example.productivity.models.LoginCredentials;
import com.example.productivity.models.User;
import com.example.productivity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("user/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return ResponseEntity.ok(
                this.userService.registerUser(user)
        );
    }
    @PostMapping("user/login")
    public ResponseEntity<User> login(@RequestBody LoginCredentials loginCredentials){
        return ResponseEntity.ok(
                this.userService.login(loginCredentials.getEmail(), loginCredentials.getPassword())
        );
    }

}
