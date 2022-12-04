package com.example.productivity.controller;

import com.example.productivity.controllers.NoteController;
import com.example.productivity.controllers.UserController;
import com.example.productivity.models.Note;
import com.example.productivity.models.User;
import com.example.productivity.repository.NoteRepository;
import com.example.productivity.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
public class NoteControllerTest {
    @MockBean
    private NoteRepository noteRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateNote() throws Exception {
        Note note = new Note("Note number 1", "Note details goes here", new User());

        mockMvc.perform(post("/api/user/register").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(note)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void shouldReturnListOfNotes() throws Exception {
        List<Note> notes = new ArrayList<>(
                Arrays.asList(new Note("Random Note", "Note details 2 goes here ", new User()),
                        new Note("Second random note", "Note details 3 goes here", new User()),
                        new Note("Third Random note", "Note details 4 goes here", new User())));

        when(noteRepository.findAll()).thenReturn(notes);
        mockMvc.perform(get("/api/notes/getAll?id=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(notes.size()))
                .andDo(print());
    }
}
