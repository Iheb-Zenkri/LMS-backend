package App.LMS.repository.Course;

import App.LMS.model.Course.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByModuleId(Long moduleId);

    List<Lesson> findByTitleContainingIgnoreCase(String title);

    List<Lesson> findByModuleIdOrderByLessonOrderAsc(Long moduleId);
}