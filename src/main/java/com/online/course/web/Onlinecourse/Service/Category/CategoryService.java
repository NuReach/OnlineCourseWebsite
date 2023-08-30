package com.online.course.web.Onlinecourse.Service.Category;

import com.online.course.web.Onlinecourse.Entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory( Category category);
    List<Category> getAllCategories();

    Category getCategoryById( Long id);

    Category updateCategory( Long id , Category categoryUpdated);


    void deleteCategory(Long id );
}
