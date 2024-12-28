package Rajesh.projectmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(GenerationType.AUTO)
    private Long id;
    private LocalDate subscriptionStartDate;
    private LocalDate getsubscriptionEndDate;

    private PlanType planType;

    private boolean isValid;

    @OneToOne
    private User user;
}
