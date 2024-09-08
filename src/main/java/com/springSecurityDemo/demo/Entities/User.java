package com.springSecurityDemo.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String firstName;
    @Column(unique = true)
    private String lasName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Courses> course;
    private String gender;
    private String phoneNo;
    private String Address;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

}
