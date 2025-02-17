package App.LMS.model.User;

import App.LMS.enums.EnrollmentStatus;
import App.LMS.model.Assessment.Certificate;
import App.LMS.model.Enrollment.Enrollment;
import App.LMS.model.Enrollment.ProgressTracking;
import App.LMS.model.Payment.Payment;
import App.LMS.model.Payment.Subscription;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "students",
        indexes = @Index(name = "idx_student_email", columnList = "email", unique = true))
public class Student extends User {

    private EnrollmentStatus enrollmentStatus;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Certificate> certificates = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProgressTracking> progressTracking = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payment> payments = new HashSet<>(); // Relationship with Payment

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Subscription> subscriptions = new HashSet<>(); // Relationship with Subscription

    public void addPayment(Payment payment) {
        payments.add(payment);
        payment.setStudent(this);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
        payment.setStudent(null);
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
        subscription.setStudent(this);
    }

    public void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
        subscription.setStudent(null);
    }    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
        enrollment.setStudent(this);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
        enrollment.setStudent(null);
    }

    public void addProgressTracking(ProgressTracking progressTracking) {
        this.progressTracking.add(progressTracking);
        progressTracking.setStudent(this);
    }

    public void removeProgressTracking(ProgressTracking progressTracking) {
        this.progressTracking.remove(progressTracking);
        progressTracking.setStudent(null);
    }
}
