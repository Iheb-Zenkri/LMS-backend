package App.LMS.model.Attempt;

import App.LMS.model.Assessment.Question;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "question-attempt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_attempt_id", nullable = false)
    private QuizAttempt quizAttempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @NotBlank(message = "Answer is mandatory")
    private String answer ;

    private boolean isCorrect ;

    @Setter(AccessLevel.NONE)
    @Min(value = 0, message = "Score must be at least 0")
    private int score ;

    public void setScore(int score) {
        if (this.question != null && score > this.question.getPassingScore()) {
            throw new IllegalArgumentException("Score cannot exceed quiz max score: " + this.question.getPassingScore());
        }
        this.score = score;
    }
}
