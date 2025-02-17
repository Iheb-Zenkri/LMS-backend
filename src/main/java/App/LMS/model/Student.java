package App.LMS.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {
    private String enrollmentStatus; // Enum :ACTIVE, INACTIVE
    // progress in each course
}
