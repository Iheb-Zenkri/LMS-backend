package App.LMS.model.Payment;

import App.LMS.enums.PaymentStatus;
import App.LMS.model.User.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Student ID is mandatory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @NotNull(message = "Plan ID is mandatory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @PrePersist
    protected void onCreate() {
        startDate = LocalDateTime.now();
        endDate = startDate.plusMonths(plan.getDurationInMonths());
    }
}