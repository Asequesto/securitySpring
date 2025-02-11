package kz.Aseke.security.securitySpring.api;


import kz.Aseke.security.securitySpring.model.Course;
import kz.Aseke.security.securitySpring.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/course")
public class CourseController {

    private final CourseService courseService;


    @GetMapping(value = "/get-course-list")
    public List<Course> getCourses(){
        return courseService.getAllCourses();
    }

}
