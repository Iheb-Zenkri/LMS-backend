package App.LMS.repository.Enrollment;

import App.LMS.model.Enrollment.ProgressTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressTrackingRepository extends JpaRepository<ProgressTracking, Long> {
    List<ProgressTracking> findByStudentId(Long studentId);

    List<ProgressTracking> findByLessonId(Long lessonId);

    List<ProgressTracking> findByCompleted(boolean completed);

    List<ProgressTracking> findByStudentIdAndCompleted(Long studentId, boolean completed);

    List<ProgressTracking> findByLessonIdAndCompleted(Long lessonId, boolean completed);
}