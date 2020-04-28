package com.codeinsyt.tigerseal.services.interfaces;

import com.codeinsyt.tigerseal.models.User;

public interface AuthService {

    User findByUsernameAndPassword(String username, String password);
}
