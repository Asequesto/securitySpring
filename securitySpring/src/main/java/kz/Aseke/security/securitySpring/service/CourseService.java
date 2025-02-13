package kz.Aseke.security.securitySpring.service;

import kz.Aseke.security.securitySpring.dto.CourseDTO;
import kz.Aseke.security.securitySpring.mapper.CourseMapper;
import kz.Aseke.security.securitySpring.model.Course;
import kz.Aseke.security.securitySpring.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;


    public List<CourseDTO> getAllCourses() {
        return courseMapper.toDtoList(courseRepository.findAll());
    }

    public CourseDTO addCourse(CourseDTO course) {
        return courseMapper.toDTO(courseMapper.toModel(course));
    }

    public CourseDTO getCourse(Long id){
        return courseMapper.toDTO(courseRepository.findById(id).orElse(null));
    }

    public CourseDTO updateCourse(CourseDTO course){
        return courseMapper.toDTO(courseRepository.save(courseMapper.toModel(course)));
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }


}
