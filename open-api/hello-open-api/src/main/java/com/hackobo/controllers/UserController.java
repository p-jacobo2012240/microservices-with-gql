package com.hackobo.controllers;

import com.hackobo.entities.User;
import com.hackobo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> users() {
        return this.userRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        User userDb = this.userRepository.save(user);
        return ResponseEntity.ok(userDb);
    }
}
