package com.online.course.web.Onlinecourse.Controller;

import com.online.course.web.Onlinecourse.Dto.CategoryDTO;
import com.online.course.web.Onlinecourse.Entity.Category;
import com.online.course.web.Onlinecourse.Execption.ResourceException;
import com.online.course.web.Onlinecourse.Mapper.CategoryMapper;
import com.online.course.web.Onlinecourse.Repository.CategoryRepository;
import com.online.course.web.Onlinecourse.Service.Category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryServiceController {
    @Autowired
    private  CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private  CategoryMapper categoryMapper;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCategories(@RequestBody CategoryDTO dto){
        Category existCategory = categoryRepository.findByName(dto.getName());
        if ( existCategory == null ){
            Category category = categoryMapper.toCategory(dto);
            category = categoryService.createCategory(category);
            return ResponseEntity.ok(category);
        }else {
            throw new ResourceException("Already exist",existCategory.getId());
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOneCategory(@PathVariable("id") Long id){
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDTO dto){
        Category category = categoryMapper.toCategory(dto);
        Category updateCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updateCategory);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
