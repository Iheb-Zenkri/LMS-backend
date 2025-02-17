package App.LMS.model.Discussion;

import App.LMS.model.User.Student;
import App.LMS.model.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "discussion_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Message is mandatory")
    private String message;

    @NotNull(message = "Thread ID is mandatory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thread_id", nullable = false)
    private DiscussionThread thread; // Relationship with DiscussionThread

    @NotNull(message = "Created by is mandatory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false) // Reference Student (or Instructor)
    private Student createdBy;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}