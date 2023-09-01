package com.online.course.web.Onlinecourse.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long id;

    @Column(name = "video_title")
    private String title;

    @Column(name = "video_description")
    private String description;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "video_image")
    private String imageLink;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
