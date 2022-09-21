package com.example.demo.services;

import com.example.demo.entite.User;

public interface IUserService {
    public User encryptPassword(User user);
    public User saveUser(User user);
}
