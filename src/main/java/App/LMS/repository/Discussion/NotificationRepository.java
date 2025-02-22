package App.LMS.repository.Discussion;

import App.LMS.enums.NotificationType;
import App.LMS.model.Discussion.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByCreatedById(Long studentId);

    List<Notification> findByType(NotificationType type);

    List<Notification> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Notification> findByCreatedByIdAndType(Long studentId, NotificationType type);
}