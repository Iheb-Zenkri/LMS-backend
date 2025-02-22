package App.LMS.repository.Attempt;

import App.LMS.model.Attempt.AssignmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, Long> {
    List<AssignmentSubmission> findByAssignmentId(Long assignmentId);

    List<AssignmentSubmission> findByStudentId(Long studentId);

    List<AssignmentSubmission> findByAssignmentIdAndStudentId(Long assignmentId, Long studentId);

    List<AssignmentSubmission> findByScoreGreaterThanEqual(int score);

    List<AssignmentSubmission> findByScoreLessThanEqual(int score);
}