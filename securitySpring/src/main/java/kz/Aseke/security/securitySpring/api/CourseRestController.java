package kz.Aseke.security.securitySpring.api;


import kz.Aseke.security.securitySpring.dto.CourseDTO;
import kz.Aseke.security.securitySpring.model.Course;
import kz.Aseke.security.securitySpring.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
@RequiredArgsConstructor
public class CourseRestController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> courseList(){
        return courseService.getAllCourses();
    }

    @GetMapping(value = "{id}")
    public CourseDTO getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO course){
        return courseService.addCourse(course);
    }

    @PutMapping
    public CourseDTO updateCourse(@RequestBody CourseDTO course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
