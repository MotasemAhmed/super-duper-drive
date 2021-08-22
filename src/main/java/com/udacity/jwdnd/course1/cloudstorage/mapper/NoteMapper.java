package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteid}")
    Note getNote(int noteid);

    @Insert("INSERT INTO notes ( notetitle,notedescription,userid) VALUES(#{notetitle}, #{notedescription},#{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int insertNote(Note note);

    @Select("SELECT * FROM notes WHERE userid = #{userid}")
    List<Note> getAllNotes(int userid);

    @Update("UPDATE notes SET notetitle = #{notetitle}, notedescription = #{notedescription} WHERE noteid = #{noteid}")
    void updateNote(Integer noteid, String notetitle, String notedescription);

    @Delete("DELETE FROM notes WHERE noteid = #{noteid}")
    Integer deleteNote(int noteid);
}
