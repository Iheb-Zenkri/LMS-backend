package App.LMS.model.Attempt;

import App.LMS.model.Assessment.Assignment;
import App.LMS.model.User.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "assignment-submission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student ;

    private LocalDateTime submissionDate ;
    private String fileUrl ;

    @Setter(AccessLevel.NONE)
    @Min(value = 0, message = "Score must be at least 0")
    private int score ;

    public void setScore(int score) {
        if (this.assignment != null && score > this.assignment.getMaxScore()) {
            throw new IllegalArgumentException("Score cannot exceed quiz max score: " + this.assignment.getMaxScore());
        }
        this.score = score;
    }

}
