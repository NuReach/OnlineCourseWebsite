package com.online.course.web.Onlinecourse.Mapper;

import com.online.course.web.Onlinecourse.Dto.CourseDTO;
import com.online.course.web.Onlinecourse.Entity.Course;
import com.online.course.web.Onlinecourse.Service.Category.CategoryService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {CategoryService.class})
public interface CourseMapper {
    @Mapping(target = "category",source = "categoryId")
    Course toCourse( CourseDTO dto);
}
