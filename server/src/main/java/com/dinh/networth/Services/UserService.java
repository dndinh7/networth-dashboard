package com.dinh.networth.Services;

import com.dinh.networth.Models.User;
import com.dinh.networth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " does not exist."));
    }

    // Email is the username
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User loadUserByUsername(String username) {
        return getUserByEmail(username);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
