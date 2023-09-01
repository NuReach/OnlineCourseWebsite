package com.online.course.web.Onlinecourse.Service.Specification;

import com.online.course.web.Onlinecourse.Entity.Category;
import com.online.course.web.Onlinecourse.Entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class CourseSpec implements Specification<Course> {

    private final CourseFilter courseFilter;
    List<Predicate> predicates = new ArrayList<>();
    @Override
    public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(courseFilter.getName() != null) {
            //Predicate name = brand.get("name").in(brandFilter.getName());

            Predicate name = cb.like(cb.upper(root.get("name")), "%"+courseFilter.getName().toUpperCase() + "%");
            predicates.add(name);
        }

        if(courseFilter.getId() != null) {
            Predicate id = root.get("id").in(courseFilter.getId());
            predicates.add(id);
        }

        Join<Course, Category> category = root.join("category");
        if(courseFilter.getCategoryId() != null) {
            Predicate id = category.get("id").in(courseFilter.getCategoryId());
            predicates.add(id);
        }
        //return cb.and(predicates.toArray(new Predicate[0]));
        return cb.and(predicates.toArray(Predicate[]::new));
    }
}
