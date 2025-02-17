package App.LMS.model.Course;

import App.LMS.model.Enrollment.ProgressTracking;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Content is mandatory")
    private String content;

    private String videoUrl; // URL to the lesson video
    private String resourceLinks; // Comma-separated resource links
    private int duration;

    @Column(name = "lesson_order")
    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;


    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProgressTracking> progressTracking = new HashSet<>();
    public void addProgressTracking(ProgressTracking progressTracking) {
        this.progressTracking.add(progressTracking);
        progressTracking.setLesson(this);
    }

    public void removeProgressTracking(ProgressTracking progressTracking) {
        this.progressTracking.remove(progressTracking);
        progressTracking.setLesson(null);
    }
}