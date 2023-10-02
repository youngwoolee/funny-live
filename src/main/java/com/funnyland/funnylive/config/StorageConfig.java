package com.funnyland.funnylive.config;

import java.nio.file.Path;

import com.funnyland.funnylive.service.ImageStorageService;
import com.funnyland.funnylive.service.LocalFileImageStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class StorageConfig {

    @Value("${local.image-upload-path}")
    private String localImageUploadPath;

    @Bean
    @Profile("local")
    public ImageStorageService localImageStorageService() {
        return new LocalFileImageStorageService(Path.of(localImageUploadPath));
    }
}
