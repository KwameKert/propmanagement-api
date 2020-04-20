package com.codeinsyt.tigerseal.services.interfaces;

import com.codeinsyt.tigerseal.models.User;

public interface UserService {

    User findByUsername(String username);
}
