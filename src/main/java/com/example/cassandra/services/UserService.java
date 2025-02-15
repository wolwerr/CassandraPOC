package com.example.cassandra.services;

import com.example.cassandra.models.User;
import com.example.cassandra.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        user.setId(UUID.randomUUID());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        var userToUpdate= userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found " + user.getId()));
        userToUpdate.setName(user.getName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setAddress_id(user.getAddress_id());
        userToUpdate.setPhones(user.getPhones());
        userRepository.save(user);
    }

}