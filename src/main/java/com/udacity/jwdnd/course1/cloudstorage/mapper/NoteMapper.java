package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE noteId = #{noteId}")
    Note getNote(int noteId);

    @Insert("INSERT INTO notes ( noteTitle,noteDescription,userId) VALUES(#{noteTitle}, #{noteDescription},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNote(Note note);

    @Select("SELECT * FROM notes WHERE userid = #{userId}")
    List<Note> getAllNotes(int userId);

    @Update("UPDATE notes SET noteTitle = #{noteTitle}, noteDescription = #{noteDescription} WHERE noteId = #{noteId}")
    void updateNote(Integer noteId, String noteTitle, String noteDescription);

    @Delete("DELETE FROM notes WHERE noteId = #{noteId}")
    Integer deleteNote(int noteId);
}
