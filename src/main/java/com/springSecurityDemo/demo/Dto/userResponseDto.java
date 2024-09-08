package com.springSecurityDemo.demo.Dto;

import com.springSecurityDemo.demo.Entities.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userResponseDto {

    private Long id;
    private String firstName;
    private String lasName;
    //private List<Courses> course;
    private String gender;
    private String phoneNo;
    private String Address;
    private String email;


}
