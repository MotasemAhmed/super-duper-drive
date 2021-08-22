package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final UserMapper userMapper;
    private final NoteMapper noteMapper;

    public NoteService(UserMapper userMapper, NoteMapper noteMapper) {
        this.userMapper = userMapper;
        this.noteMapper = noteMapper;
    }

    public Note getNote(Integer noteid) {
        return noteMapper.getNote(noteid);
    }

    public int addNote(String title, String description, String username) {
        Integer userId = userMapper.getUser(username).getUserid();
        Note note = new Note(0, userId, title, description);
        return noteMapper.insertNote(note);
    }

    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }

    public List<Note> getAllNotes(Integer userId) {
        return noteMapper.getAllNotes(userId);
    }

    public void updateNote(String title, String description, Integer noteId) {
        noteMapper.updateNote(noteId, title, description);
    }
}
