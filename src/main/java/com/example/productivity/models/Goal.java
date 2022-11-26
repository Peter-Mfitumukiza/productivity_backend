package com.example.productivity.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String whatToAchieve;
    private LocalDate deadline;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dateOfCreation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Goal() {
    }
    public Goal(String whatToAchieve, LocalDate deadline, User user) {
        this.whatToAchieve = whatToAchieve;
        this.deadline = deadline;
        this.user = user;
    }
    public Goal(Long id, String whatToAchieve, LocalDate deadline, LocalDateTime dateOfCreation, User user) {
        this.id = id;
        this.whatToAchieve = whatToAchieve;
        this.deadline = deadline;
        this.dateOfCreation = dateOfCreation;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWhatToAchieve() {
        return whatToAchieve;
    }

    public void setWhatToAchieve(String whatToAchieve) {
        this.whatToAchieve = whatToAchieve;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
