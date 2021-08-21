package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FileMapper {

    @Select("SELECT * FROM files WHERE filename = #{filename}")
    File getFile(String filename);

    @Insert("INSERT INTO files ( filename,userid,contenttype,filesize,filedata) VALUES(#{fileName}, #{owner},#{contenttype},#{filesize},#{filedata})")
    @Options(useGeneratedKeys = true, keyProperty = "fileid")
    int insertFileUrl(File file);

    @Select("SELECT * FROM files WHERE userid = #{owner}")
    List<File> getAllFiles(int userid);

    @Delete("DELETE FROM files WHERE fileid = #{fileid}")
    Integer deleteFile(int fileid);
}
