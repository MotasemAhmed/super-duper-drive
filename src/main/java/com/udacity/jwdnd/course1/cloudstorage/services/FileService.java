package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@Service
public class FileService {
    private final Path fileLocation;
    @Autowired
    private FileMapper fileMapper;

    public List<File> getAllFiles(int userId) {
        return fileMapper.getAllFiles(userId);
    }

    public File findFile(String fileName) {
        return fileMapper.getFile(fileName);
    }

    public String storeFile(MultipartFile file, User owner) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Path targetLocation = this.fileLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            fileMapper.insertFileUrl(new File(null, fileName, file.getContentType(), "" + file.getSize(), owner.getUserId(), file.getBytes()));
        } catch (IOException ex) {
            throw new StorageException(String.format("Cannot store file %s -- try again later!", fileName), ex);
        }

        return fileName;
    }

    public Integer deleteFile(int id) {

        return fileMapper.deleteFile(id);
    }

    public FileService(FileStoreConfig fileLocation) {
        this.fileLocation = Paths.get(fileLocation.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileLocation);
        } catch (IOException e) {
            throw new StorageException("Could not create a folder to store files", e);
        }
    }

    public Resource loadFile(String fileName) {
        try {
            Path filePath = this.fileLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new CannotFindFileException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new CannotFindFileException("File not found " + fileName, ex);
        }
    }
}
