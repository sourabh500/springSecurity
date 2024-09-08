package com.springSecurityDemo.demo.Controller;

import com.springSecurityDemo.demo.Dto.loginRequestDto;
import com.springSecurityDemo.demo.Dto.userResponseDto;
import com.springSecurityDemo.demo.Entities.User;
import com.springSecurityDemo.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {


    @Autowired
    private userService userService;

    @GetMapping("/")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public String Register(@RequestBody User user)
    {
        return userService.RegisterUser(user);
    }

    @PostMapping("/login")
    public userResponseDto Login(@RequestBody loginRequestDto loginRequestDto)
    {
        return userService.LoginUser(loginRequestDto);
    }



}
