package App.LMS.repository.Attempt;

import App.LMS.model.Attempt.QuestionAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAttemptRepository extends JpaRepository<QuestionAttempt, Long> {
    List<QuestionAttempt> findByQuizAttemptId(Long quizAttemptId);

    List<QuestionAttempt> findByQuestionId(Long questionId);

    List<QuestionAttempt> findByIsCorrect(boolean isCorrect);

    List<QuestionAttempt> findByScoreGreaterThanEqual(int score);

    List<QuestionAttempt> findByScoreLessThanEqual(int score);
}