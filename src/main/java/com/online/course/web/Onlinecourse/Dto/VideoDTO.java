package com.online.course.web.Onlinecourse.Dto;

import lombok.Data;

@Data
public class VideoDTO {
    private String title;
    private String description;
    private String videoLink;
    private String imageLink;
    private Long courseId;
}
