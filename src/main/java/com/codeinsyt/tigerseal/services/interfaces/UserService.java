package com.codeinsyt.tigerseal.services.interfaces;


import com.codeinsyt.tigerseal.DTO.UserDTO;
import com.codeinsyt.tigerseal.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface UserService {


    public HashMap<String, Object> createUser(UserDTO userDTO);

    public HashMap<String, Object> updateUser(UserDTO userDTO);

    public HashMap<String, Object> listUsers();

    public HashMap<String, Object> listOwners();

    public HashMap<String, Object> listCollectors();



    public HashMap<String, Object> softDelete(Long id);
}
