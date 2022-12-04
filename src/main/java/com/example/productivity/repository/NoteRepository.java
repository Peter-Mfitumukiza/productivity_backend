package com.example.productivity.repository;

import com.example.productivity.models.Note;
import com.example.productivity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    Optional<List<Note>> findNotesByUser(User user);
}
