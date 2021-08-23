package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final FileService fileService;
    private final UserService userService;
    private final NoteService noteService;
    private final CredentialService credentialService;
    private final EncryptionService encryptionService;

    public HomeController(FileService fileService, UserService userService, NoteService noteService, CredentialService credentialService, EncryptionService encryptionService) {
        this.fileService = fileService;
        this.userService = userService;
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
    }

    @GetMapping
    public String homeView(Model model, RedirectAttributes redirectAttributes, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.getUser(username);
        if (user == null || username == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please login first");
            return "redirect:/login";
        } else {
            int userId = user.getUserid();
            model.addAttribute("fileslist", fileService.getAllFiles(userId));
            model.addAttribute("noteslist", noteService.getAllNotes(userId));
            model.addAttribute("credentialslist", credentialService.getCredentials(userId));
            model.addAttribute("encryptionService", encryptionService);
            return "home";
        }
    }
}
