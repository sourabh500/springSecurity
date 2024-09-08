package com.springSecurityDemo.demo.Service;

import com.springSecurityDemo.demo.Entities.User;
import com.springSecurityDemo.demo.Entities.userPrinciples;
import com.springSecurityDemo.demo.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myUserDetails implements UserDetailsService {

    @Autowired
    private userRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user=userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }

        return new userPrinciples(user);

    }
}
