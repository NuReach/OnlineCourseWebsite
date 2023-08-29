package com.online.course.web.Onlinecourse.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_gender")
    private String gender;

    @Column(name = "user_dateOfBirth")
    private LocalDate date;

    @Column(name = "user_photo")
    private String photo;


    @Column(name = "user_joinDate")
    private LocalDate joinDate;


}
