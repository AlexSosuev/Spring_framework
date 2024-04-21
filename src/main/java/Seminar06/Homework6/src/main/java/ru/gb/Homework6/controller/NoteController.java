package ru.gb.Homework6.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.Homework6.domain.Note;
import ru.gb.Homework6.service.NoteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/create")
    public ResponseEntity<Note> CreateNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Note>> getAllNote(){
        return new ResponseEntity<>(noteService.getAllNote(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id){
        return new ResponseEntity<>(noteService.getNoteById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNoteById(id,note),HttpStatus.OK);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id){
        noteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}