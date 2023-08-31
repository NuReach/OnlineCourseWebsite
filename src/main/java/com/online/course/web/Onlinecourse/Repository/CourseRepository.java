package com.online.course.web.Onlinecourse.Repository;

import com.online.course.web.Onlinecourse.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>, JpaSpecificationExecutor<Course> {
    Course findByName(String name);
}
