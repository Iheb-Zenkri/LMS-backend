package App.LMS.model.Attempt;

import App.LMS.enums.EnrollmentStatus;
import App.LMS.model.Assessment.Question;
import App.LMS.model.Assessment.Quiz;
import App.LMS.model.User.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quiz-attempt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student ;

    @OneToMany(mappedBy = "quizAttempt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<QuestionAttempt> questionsAttempts = new HashSet<>();


    private LocalDateTime attemptDate ;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status ;

    @Setter(AccessLevel.NONE)
    @Min(value = 0, message = "Score must be at least 0")
    private int score ;

    public void setScore(int score) {
        if (this.quiz != null && score > this.quiz.getPassingScore()) {
            throw new IllegalArgumentException("Score cannot exceed quiz max score: " + this.quiz.getPassingScore());
        }
        this.score = score;
    }

}
