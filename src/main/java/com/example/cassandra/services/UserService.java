package com.example.cassandra.services;

import com.example.cassandra.models.User;
import com.example.cassandra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}