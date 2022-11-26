package com.example.productivity.services;

import com.example.productivity.models.User;
import com.example.productivity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User newUser){
        Optional<User> existingUser = userRepository.findUserByEmail(newUser.getEmail());
        if(existingUser.isPresent()){
            System.out.println("User with that email already exists");
            return null;
        }
        System.out.println("User registered successfully.");
        return userRepository.save(newUser);
    }

    public User login(String email, String password){
        if(email == null || email.equals("") || password == null){
            System.out.println("Invalid email or password");
            return null;
        }

        Optional<User> existingUser = userRepository.findUserByEmail(email);

        if(existingUser.isEmpty()){
            System.out.println("Invalid email or password");
            return null;
        }
        if(!existingUser.get().getPassword().equals(password)){
            System.out.println("Invalid email or password");
            return null;
        }
        return existingUser.get();
    }

}
