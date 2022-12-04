package com.example.productivity.services;

import com.example.productivity.models.Note;
import com.example.productivity.models.User;
import com.example.productivity.repository.NoteRepository;
import com.example.productivity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private NoteRepository noteRepository;
    private UserRepository userRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, UserRepository userRepository){
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public Optional<List<Note>> getNotes(Integer userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            return this.noteRepository.findNotesByUser(optionalUser.get());
        }
        return null;
    }

    public Note createNote(Note note){
        return this.noteRepository.save(note);
    }
    public void updateNote(Long noteId, String noteSubject, String noteDetails){

    }
}
