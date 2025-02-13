package com.example.cassandra.controllers;

import com.example.cassandra.models.User;
import com.example.cassandra.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(value = "id") UUID id) {
        Optional<User> userOptional = userService.findById(id);
        return userOptional.<ResponseEntity<Object>>map(user -> ResponseEntity.status(HttpStatus.OK).body(user))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody @Valid User userDetails) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setAddress(userDetails.getAddress());
            userService.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            userService.delete(userOptional.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    }
}