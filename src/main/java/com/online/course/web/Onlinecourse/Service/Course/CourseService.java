package com.online.course.web.Onlinecourse.Service.Course;

import com.online.course.web.Onlinecourse.Entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CourseService {
    Course createCourse( Course course);
    List<Course> getAllCourses();
    Course getCourseById ( Long id);
    Course updateCourse ( Long id , Course courseUpdated);

    void deleteCourse(Long id);

    List<Course> filterCourse(Map<String,String> params);

    Page<Course> pageCourse(Map<String,String> params);

}
