package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FileMapper {

    @Select("SELECT * FROM files WHERE userid = #{owner}")
    List<File> getAllFiles(int userId);

    @Select("SELECT * FROM files WHERE filename = #{fileName}")
    File getFile(String fileName);


    @Delete("DELETE FROM files WHERE fileId = #{fileId}")
    Integer deleteFile(int id);

    @Insert("INSERT INTO files ( filename,userid,contenttype,filesize,filedata) VALUES(#{fileName}, #{owner},#{contentType},#{fileSize},#{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insertFileUrl(File file);
}
