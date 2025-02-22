package App.LMS.repository.Payment;

import App.LMS.enums.PaymentStatus;
import App.LMS.model.Payment.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByStudentId(Long studentId);

    List<Subscription> findByPlanId(Long planId);

    List<Subscription> findByStatus(PaymentStatus status);

    List<Subscription> findByEndDateAfter(LocalDateTime currentDate);

    List<Subscription> findByEndDateBefore(LocalDateTime currentDate);
}