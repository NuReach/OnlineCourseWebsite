package com.online.course.web.Onlinecourse.Mapper;

import com.online.course.web.Onlinecourse.Dto.CategoryDTO;
import com.online.course.web.Onlinecourse.Entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category toCategory(CategoryDTO dto);
}
