package App.LMS.model.Assessment;

import App.LMS.enums.QuestionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Text is mandatory")
    private String text;

    @NotBlank(message = "Type is mandatory")
    private String type; // e.g., "multiple-choice", "true-false", "short-answer"

    private QuestionType options;
    private String correctAnswer; // Correct answer for the question
    private String explanation; // Explanation for the correct answer

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;
}