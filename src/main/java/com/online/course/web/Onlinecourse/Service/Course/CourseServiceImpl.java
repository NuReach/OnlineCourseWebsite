package com.online.course.web.Onlinecourse.Service.Course;

import com.online.course.web.Onlinecourse.Entity.Course;
import com.online.course.web.Onlinecourse.Execption.ResourceException;
import com.online.course.web.Onlinecourse.Repository.CourseRepository;
import com.online.course.web.Onlinecourse.Service.Specification.CourseFilter;
import com.online.course.web.Onlinecourse.Service.Specification.CourseSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(()-> new ResourceException("Course not found",id));
    }

    @Override
    public Course updateCourse(Long id, Course courseUpdated) {
        Course course = getCourseById(id);
        course.setName(courseUpdated.getName());
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> filterCourse(Map<String, String> params) {
        CourseFilter courseFilter = new CourseFilter();

        if(params.containsKey("name")) {
            String name = params.get("name");
            courseFilter.setName(name);
        }

        if(params.containsKey("id")) {
            String id = params.get("id");
            courseFilter.setId(Integer.parseInt(id));
        }
        if(params.containsKey("categoryId")) {
            String categoryId = params.get("categoryId");
            courseFilter.setCategoryId(Integer.parseInt(categoryId));
        }

        CourseSpec courseSpec = new CourseSpec(courseFilter);

        //page


        return courseRepository.findAll(courseSpec);
    }

    @Override
    public Page<Course> pageCourse(Map<String, String> params) {
        CourseFilter courseFilter = new CourseFilter();
        //sorting
        if(params.containsKey("name")) {
            String name = params.get("name");
            courseFilter.setName(name);
        }

        if(params.containsKey("id")) {
            String id = params.get("id");
            courseFilter.setId(Integer.parseInt(id));
        }
        if(params.containsKey("categoryId")) {
            String categoryId = params.get("categoryId");
            courseFilter.setCategoryId(Integer.parseInt(categoryId));
        }

        CourseSpec courseSpec = new CourseSpec(courseFilter);
        //page
        int pageNumber = 0;
        int pageSize = 2;
        if (params.containsKey("page")){
            pageNumber= Integer.parseInt(params.get("page"));
        }
        if (params.containsKey("size")){
            pageSize = Integer.parseInt(params.get("size"));
        }
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        return courseRepository.findAll(courseSpec,pageable);
    }


}
