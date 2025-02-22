package App.LMS.repository.Course;

import App.LMS.model.Course.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByNameIgnoreCase(String name);

    boolean existsByName(String name);
}