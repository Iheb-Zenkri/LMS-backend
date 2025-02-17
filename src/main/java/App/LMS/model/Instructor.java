package App.LMS.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue("INSTRUCTOR")
public class Instructor extends User {
    private String bio;
    private Date memberSince;
    private String subject ;
    private int rating ;
}

