package App.LMS.repository.Payment;

import App.LMS.enums.PaymentMethod;
import App.LMS.enums.PaymentStatus;
import App.LMS.model.Payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentId(Long studentId);

    List<Payment> findByCourseId(Long courseId);

    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByPaymentMethod(PaymentMethod paymentMethod);

    // Find payments by transaction ID
    Optional<Payment> findByTransactionId(String transactionId);

    // Find payments within a date range
    List<Payment> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}