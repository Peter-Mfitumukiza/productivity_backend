package com.example.productivity.controllers;

import com.example.productivity.models.Note;
import com.example.productivity.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/notes")
public class NoteController {
    private NoteService noteService;
    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
    @GetMapping("getAll")
    public Optional<List<Note>> getNotes(@RequestParam Integer userId){
        return this.noteService.getNotes(userId);
    }
    @PostMapping("save")
    public Note saveNote(@RequestBody Note newNote){
        return this.noteService.createNote(newNote);
    }
}
