package App.LMS.repository.User;

import App.LMS.model.User.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);

    boolean existsByEmail(String email);
}