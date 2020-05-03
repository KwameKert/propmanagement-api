package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.DTO.UserDTO;
import com.codeinsyt.tigerseal.models.Role;
import com.codeinsyt.tigerseal.models.User;
import com.codeinsyt.tigerseal.repositories.UserRepository;
import com.codeinsyt.tigerseal.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }


    @Override
    public HashMap<String, Object> createUser(UserDTO userDTO) {

        try{

            Role role = new Role();
            role.setRole(userDTO.getRole());
            Set<Role> setRole = new HashSet<>();
            setRole.add(role);

            User user = new User();
            user.setRoles(setRole);
            user.setPassword(userDTO.getPassword());
            user.setUsername(userDTO.getUsername());
            user.setFullName(userDTO.getFullName());
            user.setStat(userDTO.getStat());
            user.setEmail(userDTO.getEmail());


            User newUser = this.userRepository.save(user);
            return responseAPI(newUser,"User created successfully", HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }


    public Boolean userExists(Long id){
        try{

            Optional<User> userFound = this.userRepository.findById(id);

            if(userFound.isPresent()){
                return  true;
            }

            return false;

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public HashMap<String, Object> updateUser(UserDTO userDTO) {
        try{

            if(userExists(userDTO.getId())){

                User user = new User();

                User updatedUser = this.userRepository.save(user);
                return responseAPI(user,"User updated successfully", HttpStatus.OK);
            }

            return responseAPI(null,"No user found", HttpStatus.NOT_FOUND);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    List<User> findByRole( String role) {
        try {
           List<User>  users = this.userRepository.findAllByRole(role);
           return users;
        }catch(Exception e){

            return null;
        }

    }

    @Override
    public HashMap<String, Object> listUsers() {
       try{

          List<User>  users = this.userRepository.findAllUsers();
           if(!users.isEmpty())
               return responseAPI(users,"Users found",HttpStatus.FOUND);
           else
               return responseAPI(null,"Users empty",HttpStatus.NO_CONTENT);

       }catch(Exception e){
           e.printStackTrace();
           return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
       }
    }

    @Override
    public HashMap<String, Object> listOwners() {
        try{

            List<User> users = this.findByRole("OWNER");
            if(users.isEmpty()){

                return responseAPI(null,"No collectors found",HttpStatus.NO_CONTENT);
            }

            return responseAPI(users, "Owners found", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listCollectors() {
        try{
            List<User> users = this.findByRole("COLLECTOR");
            if(users.isEmpty()){

                return responseAPI(null,"No collectors found",HttpStatus.NO_CONTENT);
            }

            return responseAPI(users, "Collectors found", HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> softDelete(Long id) {

        try{

            if(userExists(id)){

                 this.userRepository.softDelete(id, "deleted");
                return responseAPI(null,"User deleted successfully", HttpStatus.OK);
            }

            return responseAPI(null,"No user found", HttpStatus.NOT_FOUND);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
