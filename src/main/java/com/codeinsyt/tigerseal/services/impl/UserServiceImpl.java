package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.models.User;
import com.codeinsyt.tigerseal.repositories.UserRepository;
import com.codeinsyt.tigerseal.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
    public HashMap<String, Object> createUser(User user) {

        try{
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
    public HashMap<String, Object> updateUser(User user) {
        try{

            if(userExists(user.getId())){

                User updatedUser = this.userRepository.save(user);
                return responseAPI(user,"User updated successfully", HttpStatus.OK);
            }

            return responseAPI(null,"No user found", HttpStatus.NOT_FOUND);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> listUsers() {

       try{
           List<User>  users = this.userRepository.findAllByStatOrderByIdAsc("active");

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
