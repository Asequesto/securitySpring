package kz.Aseke.security.securitySpring.mapper;

import kz.Aseke.security.securitySpring.dto.CourseDTO;
import kz.Aseke.security.securitySpring.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO toDTO(Course course);
    Course toModel(CourseDTO courseDTO);

    List<CourseDTO> toDtoList(List<Course> courseList);
    List<Course> toModelList(List<CourseDTO> courseDTOList);

}
