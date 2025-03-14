package kz.Aseke.security.securitySpring.api;


import kz.Aseke.security.securitySpring.dto.CourseDTO;
import kz.Aseke.security.securitySpring.model.Course;
import kz.Aseke.security.securitySpring.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/course")
public class CourseController {

    private final CourseService courseService;


    @GetMapping(value = "/get-course-list")
    public List<CourseDTO> getCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping(value = "/add-course")
    public CourseDTO addCourse(@RequestBody CourseDTO course){
        return courseService.addCourse(course);
    }

}
