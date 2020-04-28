package com.codeinsyt.tigerseal.services.interfaces;


import com.codeinsyt.tigerseal.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface UserService {


    public HashMap<String, Object> createUser(User user);

    public HashMap<String, Object> updateUser(User user);

    public HashMap<String, Object> listUsers();

    public HashMap<String, Object> softDelete(Long id);
}
