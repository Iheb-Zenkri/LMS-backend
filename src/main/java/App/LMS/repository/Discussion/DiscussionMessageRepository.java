package App.LMS.repository.Discussion;

import App.LMS.model.Discussion.DiscussionMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DiscussionMessageRepository extends JpaRepository<DiscussionMessage, Long> {
    List<DiscussionMessage> findByThreadId(Long threadId);

    List<DiscussionMessage> findByCreatedById(Long studentId);

    List<DiscussionMessage> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<DiscussionMessage> findByThreadIdAndCreatedById(Long threadId, Long studentId);
}