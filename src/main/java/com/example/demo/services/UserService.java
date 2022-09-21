package com.example.demo.services;

import com.example.demo.entite.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService implements IUserService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepository;
    @Override
    public User encryptPassword(User user) {
        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
        return user;
    }
    public User saveUser(User user){
        return userRepository.save(encryptPassword(user));
    }
}
