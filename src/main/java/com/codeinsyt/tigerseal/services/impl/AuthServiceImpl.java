package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.models.User;
import com.codeinsyt.tigerseal.repositories.UserRepository;
import com.codeinsyt.tigerseal.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {

        try{
            return this.userRepository.findByUsernameAndPassword(username, password);
        }catch(Exception e){
            return null;
        }

    }



    public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {

        User user = findByUsernameAndPassword(username, password);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        return new AuthDetailsImpl(user);

    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
