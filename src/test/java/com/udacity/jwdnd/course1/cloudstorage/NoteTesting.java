package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteTesting extends CloudStorageApplicationTests {


    private void deleteNote(HomePage homePage) {
        homePage.deleteNote();
    }

    private void createNote(String noteTitle, String noteDescription, HomePage homePage) {
        homePage.openNotesTab();
        homePage.addNewNote();
        homePage.setNoteTitle(noteTitle);
        homePage.setNoteDescription(noteDescription);
        homePage.saveNoteChanges();
        homePage.openNotesTab();
    }

    @Test
    public void deleteNoteTest() throws InterruptedException {
        String noteTitle = "My Note";
        String noteDescription = "This is my note.";
        HomePage homePage = getHomePage();
        createNote(noteTitle, noteDescription, homePage);
        homePage.openNotesTab();
        homePage = new HomePage(driver);
        Thread.sleep(2000);
        Assertions.assertFalse(homePage.noNotes(driver));

        Thread.sleep(2000);
        deleteNote(homePage);

        Thread.sleep(2000);
        Assertions.assertTrue(homePage.noNotes(driver));
    }

    @Test
    public void noteUpdateTest() throws InterruptedException {
        String noteTitle = "My Note";
        String noteDescription = "This is my note test.";
        HomePage homePage = getHomePage();
        createNote(noteTitle, noteDescription, homePage);
        homePage.openNotesTab();
        homePage = new HomePage(driver);
        homePage.editNote();
        String modifiedNoteTitle = "Modified Note";
        homePage.modifyNoteTitle(modifiedNoteTitle);

        String modifiedNoteDescription = "This is my modified note.";
        homePage.modifyNoteDescription(modifiedNoteDescription);

        homePage.saveNoteChanges();
        homePage.openNotesTab();
        Note note = homePage.getFirstNote();
        Assertions.assertEquals(modifiedNoteTitle, note.getNoteTitle());
        Assertions.assertEquals(modifiedNoteDescription, note.getNoteDescription());
    }

    @Test
    public void createReadTest() throws InterruptedException {
        String noteTitle = "Note title";
        String noteDescription = "This is note to test.";
        HomePage homePage = getHomePage();
        assertEquals("Home", driver.getTitle());
        createNote(noteTitle, noteDescription, homePage);
        homePage.openNotesTab();
        homePage = new HomePage(driver);
        Note note = homePage.getFirstNote();
        Assertions.assertEquals(noteTitle, note.getNoteTitle());
        Assertions.assertEquals(noteDescription, note.getNoteDescription());
        deleteNote(homePage);
        Thread.sleep(4000);
        homePage.logout();
    }


}
