package com.online.course.web.Onlinecourse.Mapper;

import com.online.course.web.Onlinecourse.Dto.CourseDTO;
import com.online.course.web.Onlinecourse.Dto.VideoDTO;
import com.online.course.web.Onlinecourse.Entity.Course;
import com.online.course.web.Onlinecourse.Entity.Video;
import com.online.course.web.Onlinecourse.Service.Category.CategoryService;
import com.online.course.web.Onlinecourse.Service.Course.CourseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring",uses = {CourseService.class})
public interface VideoMapper {
    @Mapping(target = "course",source = "courseId")
    Video toVideo(VideoDTO dto);
}

