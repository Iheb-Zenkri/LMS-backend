package App.LMS.repository.Enrollment;

import App.LMS.enums.EnrollmentStatus;
import App.LMS.model.Enrollment.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);

    List<Enrollment> findByCourseId(Long courseId);

    List<Enrollment> findByStatus(EnrollmentStatus status);

    List<Enrollment> findByStudentIdAndStatus(Long studentId, EnrollmentStatus status);

    List<Enrollment> findByCourseIdAndStatus(Long courseId, EnrollmentStatus status);

    boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);
}