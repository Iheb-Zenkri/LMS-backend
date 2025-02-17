package App.LMS.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "admins",
        indexes = @Index(name = "idx_admin_email", columnList = "email", unique = true)
)
public class Admin extends User {

    // we can add multiple admins with multiple roles
    // in future updates when the app scale up !

}
