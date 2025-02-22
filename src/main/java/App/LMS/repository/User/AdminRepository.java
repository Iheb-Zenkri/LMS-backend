package App.LMS.repository.User;

import App.LMS.model.User.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Custom query to find an admin by email
    Admin findByEmail(String email);

    // Custom query to check if an admin exists by email
    boolean existsByEmail(String email);
}