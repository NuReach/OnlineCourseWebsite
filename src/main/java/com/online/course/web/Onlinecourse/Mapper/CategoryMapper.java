package com.online.course.web.Onlinecourse.Mapper;

import com.online.course.web.Onlinecourse.Dto.CategoryDTO;
import com.online.course.web.Onlinecourse.Entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    Category toCategory(CategoryDTO dto);
}
