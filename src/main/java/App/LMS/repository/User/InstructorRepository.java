package App.LMS.repository.User;

import App.LMS.model.User.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Instructor findByEmail(String email);

    boolean existsByEmail(String email);

    List<Instructor> findByRatingGreaterThanEqual(double rating);

    List<Instructor> findBySubjects_Name(String subjectName);
}