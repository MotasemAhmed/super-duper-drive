package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("notes")
public class NoteController {
    private final NoteService noteService;
    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping
    public List<Note> getNotes(int userId) {
        return noteService.getAllNotes(userId);
    }

    @PostMapping
    public String addNote(Authentication authentication, Note note, RedirectAttributes redirectAttributes) {
        String username = authentication.getName();
        User user = userService.getUser(username);

        if (note.getNoteId() != null && note.getNoteId() > 0) {
            try {
                noteService.updateNote(note.getNoteTitle(), note.getNoteDescription(), note.getNoteId());
                redirectAttributes.addFlashAttribute("successMessage", "Your note was updated successful.");
                return "redirect:/home";
            } catch (Exception ex) {
                redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong with the note update. Please try again!");
                return "redirect:/home";
            }
        } else {
            try {
                note.setUserId(user.getUserId());
                noteService.addNote(note);
                redirectAttributes.addFlashAttribute("successMessage", "Note added");
                return "redirect:/home";
            } catch (Exception ex) {
                System.out.println(ex);
                redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong with the note creation. Please try again!");
                return "redirect:/home";
            }
        }
    }

    @GetMapping("/delete/{noteId}")
    public String deleteNote(@PathVariable int noteId, RedirectAttributes redirectAttributes) {
        try {
            noteService.deleteNote(noteId);
            redirectAttributes.addFlashAttribute("successMessage", "Your note was deleted successful.");
            return "redirect:/home";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong with the note delete. Please try again!");
            return "redirect:/home";
        }
    }
}
