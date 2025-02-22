package App.LMS.repository.Course;

import App.LMS.model.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContainingIgnoreCase(String title);

    List<Course> findByInstructorId(Long instructorId);

    List<Course> findByCategoryId(Long subjectId);

    boolean existsByTitle(String title);
}