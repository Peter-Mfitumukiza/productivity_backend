package com.example.productivity.controllers;

import com.example.productivity.payload.request.LoginRequest;
import com.example.productivity.models.User;
import com.example.productivity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("register")
    public User registerUser(@RequestBody User user){
        return this.userService.registerUser(user);
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(
                this.userService.login(loginRequest.getEmail(), loginRequest.getPassword())
        );
    }

}
