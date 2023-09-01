package com.online.course.web.Onlinecourse.Service.Specification;

import com.online.course.web.Onlinecourse.Entity.Category;
import com.online.course.web.Onlinecourse.Entity.Course;
import com.online.course.web.Onlinecourse.Entity.Video;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class VideoSpec implements Specification<Video> {
    private final VideoFilter videoFilter;
    List<Predicate> predicates = new ArrayList<>();
    @Override
    public Predicate toPredicate(Root<Video> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(videoFilter.getTitle() != null) {
            //Predicate name = brand.get("name").in(brandFilter.getName());

            Predicate title = cb.like(cb.upper(root.get("title")), "%"+videoFilter.getTitle().toUpperCase() + "%");
            predicates.add(title);
        }

        if(videoFilter.getId() != null) {
            Predicate id = root.get("id").in(videoFilter.getId());
            predicates.add(id);
        }

        Join<Video, Course> course = root.join("course");
        if(videoFilter.getCourseId() != null) {
            Predicate id = course.get("id").in(videoFilter.getCourseId());
            predicates.add(id);
        }
        //return cb.and(predicates.toArray(new Predicate[0]));
        return cb.and(predicates.toArray(Predicate[]::new));
    }
}
