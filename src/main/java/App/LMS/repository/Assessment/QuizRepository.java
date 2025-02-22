package App.LMS.repository.Assessment;

import App.LMS.model.Assessment.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCourseId(Long courseId);

    List<Quiz> findByTitleContainingIgnoreCase(String title);

    List<Quiz> findByPassingScoreGreaterThanEqual(int passingScore);
}