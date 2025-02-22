package App.LMS.repository.Assessment;

import App.LMS.enums.QuestionType;
import App.LMS.model.Assessment.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuizId(Long quizId);

    List<Question> findByType(QuestionType type);

    List<Question> findByTextContainingIgnoreCase(String text);
}