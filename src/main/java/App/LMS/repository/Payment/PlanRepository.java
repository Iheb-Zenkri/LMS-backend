package App.LMS.repository.Payment;

import App.LMS.model.Payment.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByNameContainingIgnoreCase(String name);

    List<Plan> findByPriceLessThanEqual(double price);

    List<Plan> findByDurationInMonths(int durationInMonths);

    boolean existsByName(String name);
}