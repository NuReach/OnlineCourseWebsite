package com.online.course.web.Onlinecourse.Service.Category;

import com.online.course.web.Onlinecourse.Entity.Category;
import com.online.course.web.Onlinecourse.Execption.ResourceException;
import com.online.course.web.Onlinecourse.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceException("Category not found",id));
    }

    @Override
    public Category updateCategory(Long id, Category categoryUpdated) {
        Category category = getCategoryById(id);
        category.setName(categoryUpdated.getName());
        return categoryRepository.save(category);
    }


    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
