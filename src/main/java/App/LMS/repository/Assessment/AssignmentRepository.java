package App.LMS.repository.Assessment;

import App.LMS.model.Assessment.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourseId(Long courseId);

    List<Assignment> findByTitleContainingIgnoreCase(String title);

    List<Assignment> findByDeadlineAfter(LocalDateTime deadline);

    List<Assignment> findByDeadlineBefore(LocalDateTime deadline);
}