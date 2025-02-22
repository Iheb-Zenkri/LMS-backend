package App.LMS.repository.Assessment;

import App.LMS.model.Assessment.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findByStudentId(Long studentId);

    List<Certificate> findByCourseId(Long courseId);

    List<Certificate> findByIssuedAtAfter(LocalDateTime issuedAt);

    List<Certificate> findByIssuedAtBefore(LocalDateTime issuedAt);
}