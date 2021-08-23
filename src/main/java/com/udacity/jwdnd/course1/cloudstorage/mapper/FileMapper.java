package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FileMapper {

    @Select("SELECT * FROM files WHERE fileName = #{fileName}")
    File getFile(String fileName);

    @Insert("INSERT INTO files ( fileName,userId,userId,fileSize,fileData) VALUES(#{fileName}, #{owner},#{userId},#{fileSize},#{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insertFile(File file);

    @Select("SELECT * FROM files WHERE userId = #{owner}")
    List<File> getAllFiles(int userId);

    @Delete("DELETE FROM files WHERE fileId = #{fileId}")
    Integer deleteFile(int fileId);
}
