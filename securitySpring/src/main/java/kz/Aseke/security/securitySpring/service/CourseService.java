package kz.Aseke.security.securitySpring.service;

import kz.Aseke.security.securitySpring.model.Course;
import kz.Aseke.security.securitySpring.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

}
