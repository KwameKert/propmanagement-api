package com.codeinsyt.tigerseal.services.interfaces;

import com.codeinsyt.tigerseal.models.PropertyOwner;
import com.codeinsyt.tigerseal.models.User;

import java.util.HashMap;

public interface UserService {

    User findByUsernameAndPassword(String username, String password);

    public HashMap<String, Object> createUser(User user);

    public HashMap<String, Object> updateUser(User user);

    public HashMap<String, Object> listUsers();

    public HashMap<String, Object> softDelete(Long id);
}
