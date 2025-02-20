package App.LMS.model.User;

import App.LMS.model.Course.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "instructors",
        indexes = @Index(name = "idx_instructor_email", columnList = "email", unique = true)
)
public class Instructor extends User {

    @NotNull(message = "bio is required")
    @Size(max = 500, message = "Bio must be at most 500 characters")
    private String bio;

    @NotNull(message = "Start date is required")
    private LocalDate careerStartDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "instructor_subjects",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects = new HashSet<>();

    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 10, message = "Rating cannot exceed 10")
    private double rating;

    public int getYearsOfExperience() {
        return Period.between(careerStartDate, LocalDate.now()).getYears();
    }
}


