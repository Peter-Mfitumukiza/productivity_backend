package com.example.productivity.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class CalendarReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reminderDetails;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime dateOfCreation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public CalendarReminder(String reminderDetails, LocalDateTime dateOfCreation) {
        this.reminderDetails = reminderDetails;
        this.dateOfCreation = dateOfCreation;
    }
    public CalendarReminder() {
    }
    public CalendarReminder(Long id, String reminderDetails, LocalDateTime dateOfCreation, User user) {
        this.id = id;
        this.reminderDetails = reminderDetails;
        this.dateOfCreation = dateOfCreation;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getReminderDetails() {
        return reminderDetails;
    }
    public void setReminderDetails(String reminderDetails) {
        this.reminderDetails = reminderDetails;
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
