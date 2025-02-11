package kz.Aseke.security.securitySpring.repository;

import jakarta.transaction.Transactional;
import kz.Aseke.security.securitySpring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Long> {
}
