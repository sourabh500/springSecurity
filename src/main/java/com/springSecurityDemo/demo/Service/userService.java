package com.springSecurityDemo.demo.Service;

import com.springSecurityDemo.demo.Dto.loginRequestDto;
import com.springSecurityDemo.demo.Dto.userResponseDto;
import com.springSecurityDemo.demo.Entities.User;
import com.springSecurityDemo.demo.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private userRepo userRepo;

    @Autowired
    private AuthenticationManager authManager;


    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    public String RegisterUser(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User is successfully registered";
    }

    public userResponseDto LoginUser(loginRequestDto dto) {

        try {

            Authentication authenticate = authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

            if
            (authenticate.isAuthenticated()) {
                // Fetch the user details from the database

                User user = userRepo.findByEmail(dto.getEmail());
                if (user != null) {
                    // Create and return the UserResponseDto
                    return new userResponseDto(
                            user.getId(),
                            user.getFirstName(),
                            user.getLasName(),
                            user.getGender(),
                            user.getPhoneNo(),
                            user.getAddress(),
                            user.getEmail());

                }
            }
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid credentials");
        }
        return null; // Return null or handle as appropriate
    }
}

