package com.dinh.networth.Services;

import com.dinh.networth.Models.User;
import com.dinh.networth.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository= userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " does not exist."));
    }

    // Email is the username
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
