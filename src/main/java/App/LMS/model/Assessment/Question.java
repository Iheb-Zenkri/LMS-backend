package App.LMS.model.Assessment;

import App.LMS.enums.QuestionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    private Set<String> options = new HashSet<>(); // if type = multiple-options question

    @NotBlank(message = "Correct Answer is mandatory")
    private String correctAnswer;
    private String explanation;

    @Min(value = 0, message = "Score must be at least 0")
    @Max(value = 100, message = "Score cannot exceed 100")
    private int passingScore ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;
}