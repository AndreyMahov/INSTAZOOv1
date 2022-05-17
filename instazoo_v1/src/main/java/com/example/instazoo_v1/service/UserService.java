package com.example.instazoo_v1.service;

import com.example.instazoo_v1.entity.User;
import com.example.instazoo_v1.entity.enums.ERole;
import com.example.instazoo_v1.exceptions.UserExistException;
import com.example.instazoo_v1.payLoad.request.SignupRequest;
import com.example.instazoo_v1.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, BCryptPasswordEncoder passwordEncoder1) {
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
    }

    public User createUser(SignupRequest userIn){
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setName(userIn.getFirstname());
        user.setLastName(userIn.getLastname());
        user.setUsername(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRoles().add(ERole.ROLE_USER);
        try {
            LOG.info("Saving User {}",userIn.getEmail());
            return userRepository.save(user);
        } catch (Exception ex){
            LOG.error("Error during registration",ex.getMessage());
            throw new UserExistException(" the user " + userIn.getUsername() + " already exist ");
        }

    }

}
