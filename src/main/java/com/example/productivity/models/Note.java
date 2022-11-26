package com.example.productivity.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String noteSubject;
    private String noteDetails;
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate dateOfCreation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Note() {
    }

    public Note(String noteSubject, String noteDetails, User user) {
        this.noteSubject = noteSubject;
        this.noteDetails = noteDetails;
        this.user = user;
    }

    public Note(Long id, String noteSubject, String noteDetails, LocalDate dateOfCreation, User user) {
        this.id = id;
        this.noteSubject = noteSubject;
        this.noteDetails = noteDetails;
        this.dateOfCreation = dateOfCreation;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoteSubject() {
        return noteSubject;
    }

    public void setNoteSubject(String noteSubject) {
        this.noteSubject = noteSubject;
    }

    public String getNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(String noteDetails) {
        this.noteDetails = noteDetails;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
