package com.udacity.jwdnd.course1.cloudstorage.services;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FileStoreConfig {

    public String getUploadDir() {
        return "./uploads/";
    }

}
