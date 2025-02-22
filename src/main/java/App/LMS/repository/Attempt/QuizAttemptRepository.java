package App.LMS.repository.Attempt;

import App.LMS.enums.EnrollmentStatus;
import App.LMS.model.Attempt.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
    List<QuizAttempt> findByQuizId(Long quizId);

    List<QuizAttempt> findByStudentId(Long studentId);

    List<QuizAttempt> findByQuizIdAndStudentId(Long quizId, Long studentId);

    List<QuizAttempt> findByStatus(EnrollmentStatus status);

    List<QuizAttempt> findByScoreGreaterThanEqual(int score);

    List<QuizAttempt> findByScoreLessThanEqual(int score);
}