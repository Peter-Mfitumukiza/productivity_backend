package com.example.productivity.service;
import com.example.productivity.models.Note;
import com.example.productivity.repository.NoteRepository;
import com.example.productivity.services.NoteService;
import com.example.productivity.services.UserService;
import com.startwithjava.dao.UserDao;
import com.startwithjava.dto.User;
import com.startwithjava.service.dto.UserDto;
import com.startwithjava.translator.BaseTranslator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class NoteServiceTest {
    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteService noteService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll_WhenRecordPresent_ReturnList(){
        //Given
        when(noteService.getNotes(4)).thenReturn(Arrays.asList(new Note()));
        //When
        Optional<List<Note>> notes= noteService.getNotes(4);

        //Then
        assertFalse(notes.isEmpty());
        verify(noteService,times(1)).getNotes(4);
    }
}
