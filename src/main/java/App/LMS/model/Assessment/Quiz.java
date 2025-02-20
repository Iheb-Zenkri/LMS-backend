package App.LMS.model.Assessment;

import App.LMS.model.Course.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quizzes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @Setter(AccessLevel.NONE)
    @Min(value = 0, message = "Score must be at least 0")
    private int passingScore = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions = new HashSet<>();

    // Helper methods to manage bidirectional relationships
    public void addQuestion(Question question) {
        questions.add(question);
        question.setQuiz(this);
        if(question.getPassingScore() > 0){
           this.passingScore += question.getPassingScore() ;
        }
    }

    public void removeQuestion(Question question) {
        if(question.getPassingScore() > 0){
            this.passingScore -= question.getPassingScore() ;
        }
        questions.remove(question);
        question.setQuiz(null);
    }
}