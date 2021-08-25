package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.SecureRandom;
import java.util.Base64;

@Controller
@RequestMapping("/credential")
public class CredentialController {
    private final UserService userService;
    private final CredentialService credentialService;
    private final EncryptionService encryptionService;

    @GetMapping("/delete/{credentialId}")
    public String deleteNote(@PathVariable int credentialId, RedirectAttributes redirectAttributes) {
        try {
            credentialService.deleteCredential(credentialId);
            redirectAttributes.addFlashAttribute("successMessage", "credentials deleted successfully.");
            return "redirect:/home";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong");
            return "redirect:/home";
        }
    }

    @PostMapping
    public String createOrUpdateCredential(Credential credential, Authentication authentication, RedirectAttributes redirectAttributes) {

        String secretKey = generateSecretKey();
        String encryptPassword = encryptionService.encryptValue(credential.getPassword(), secretKey);
        credential.setKey(secretKey);
        credential.setPassword(encryptPassword);

        if (credential.getCredentialId() != null && credential.getCredentialId() > 0) {
            try {
                credentialService.updateCredential(credential);
                redirectAttributes.addFlashAttribute("successMessage", "credentials updated successfully.");
                return "redirect:/home";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong");
                return "redirect:/home";
            }
        } else {
            try {
                String username = authentication.getName();
                int userId = userService.getUser(username).getUserId();
                credential.setUserId(userId);
                credentialService.createCredential(credential);
                redirectAttributes.addFlashAttribute("successMessage", "credentials created successfully.");
                return "redirect:/home";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong");
                return "redirect:/home";
            }
        }
    }

    private String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    public CredentialController(UserService userService, CredentialService credentialService, EncryptionService encryptionService) {
        this.userService = userService;
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
    }

}
