package App.LMS.model.Course;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "subjects",
        indexes = @Index(name = "idx_name", columnList = "name", unique = true)
)
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subject name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;
}
