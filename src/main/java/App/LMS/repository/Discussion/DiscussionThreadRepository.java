package App.LMS.repository.Discussion;

import App.LMS.model.Discussion.DiscussionThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DiscussionThreadRepository extends JpaRepository<DiscussionThread, Long> {
    List<DiscussionThread> findByCourseId(Long courseId);

    List<DiscussionThread> findByCreatedById(Long studentId);

    List<DiscussionThread> findByTitleContainingIgnoreCase(String title);

    List<DiscussionThread> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}