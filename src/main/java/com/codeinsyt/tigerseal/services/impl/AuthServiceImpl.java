package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.models.User;
import com.codeinsyt.tigerseal.repositories.UserRepository;
import com.codeinsyt.tigerseal.services.interfaces.UserService;
import com.codeinsyt.tigerseal.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;
    private JwtUtil jwtTokenUtil;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
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
        User user = this.userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        return new AuthDetailsImpl(user);

    }


    public HashMap<String, Object> loginUser(String username,String password) throws Exception {

        HashMap<String, Object> result = new HashMap<>();

        final UserDetails userDetails = loadUserByUsername(username,password);

        if(userDetails.getUsername() != null){
            String jwt = getJwt(userDetails);
            result.put("token", jwt);
            result.put("message","User authenticated");
            result.put("status", HttpStatus.OK);
        }else{
            result.put("data", null);
            result.put("message","User authenticated");
            result.put("status", HttpStatus.EXPECTATION_FAILED);
        }

        return result;
    }


    String getJwt(UserDetails userDetails)throws Exception{

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return jwt;
    }

}
