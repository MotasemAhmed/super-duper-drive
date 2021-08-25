package com.udacity.jwdnd.course1.cloudstorage.model;

public class Note {
    private Integer noteId;
    private Integer userId;
    private String noteTitle;
    private String noteDescription;

    public Note(String title, String description) {
        this.noteTitle = title;
        this.noteDescription = description;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public Integer getUserId() {
        return userId;
    }


    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }
}
