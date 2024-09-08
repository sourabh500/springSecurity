package com.springSecurityDemo.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Courses {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Id
    private User user;
    @Column(name = "course_name")
    private String name;
    private String duration;

}