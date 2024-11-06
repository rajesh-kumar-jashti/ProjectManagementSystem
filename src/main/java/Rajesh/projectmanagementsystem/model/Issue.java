package Rajesh.projectmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    private User assignee;
}
