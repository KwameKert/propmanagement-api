package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.models.User;
import com.codeinsyt.tigerseal.repositories.UserRepository;
import com.codeinsyt.tigerseal.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }


}
