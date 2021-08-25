package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteMapper noteMapper;

    public List<Note> getAllNotes(Integer userId) {
        return noteMapper.getAllNotes(userId);
    }

    public Note getNote(Integer noteid) {
        return noteMapper.getNote(noteid);
    }

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public void updateNote(String title, String description, Integer noteId) {
        noteMapper.updateNote(noteId, title, description);
    }

    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }

    public int addNote(Note note) {
        return noteMapper.insertNote(note);
    }

}
