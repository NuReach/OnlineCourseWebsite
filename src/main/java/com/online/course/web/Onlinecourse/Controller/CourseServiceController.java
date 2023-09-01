package com.online.course.web.Onlinecourse.Controller;

import com.online.course.web.Onlinecourse.Dto.CourseDTO;
import com.online.course.web.Onlinecourse.Entity.Course;
import com.online.course.web.Onlinecourse.Execption.ResourceException;
import com.online.course.web.Onlinecourse.Mapper.CourseMapper;
import com.online.course.web.Onlinecourse.Repository.CourseRepository;
import com.online.course.web.Onlinecourse.Service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("courses")
public class CourseServiceController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO dto){
        Course existCourse = courseRepository.findByName(dto.getName());
        if ( existCourse == null ){
            Course course = courseMapper.toCourse(dto);
            course = courseService.createCourse(course);
            return ResponseEntity.ok(course);
        }else {
            throw new ResourceException("Already exist",existCourse.getId());
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id){
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(@PathVariable("id") Long id, @RequestBody CourseDTO dto){
       Course courseUpdated= courseService.updateCourse(id,courseMapper.toCourse(dto));
        return ResponseEntity.ok(courseUpdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "filterSpec")
    public ResponseEntity<?> filterCourse(@RequestParam Map<String,String> params){
        List<Course> list= courseService.filterCourse(params);
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "filter")
    public ResponseEntity<?> pageCourse(@RequestParam Map<String,String> params){
        Page<Course> list = courseService.pageCourse(params);
        return ResponseEntity.ok(list);
    }
}
