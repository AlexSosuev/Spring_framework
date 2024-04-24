package ru.gb.Homework6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Homework6.domain.Note;
import ru.gb.Homework6.repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

// Получение списка заметок
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }
// Создание заметки
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }
//Найти заметку по ID
   public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }
//Изменение заметки по Id
    public Note updateNoteById(Long id, Note note) {
        note.setId(id);
        return noteRepository.save(note);
    }
//Удаление заметки по Id
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}