package com.online.course.web.Onlinecourse.Mapper;

import com.online.course.web.Onlinecourse.Dto.CategoryDTO;
import com.online.course.web.Onlinecourse.Entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryDTO dto);
}
