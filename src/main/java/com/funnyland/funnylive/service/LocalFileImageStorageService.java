package com.funnyland.funnylive.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
public class LocalFileImageStorageService implements ImageStorageService {

    private final Path imageUploadPath;

    @Override
    public String upload(MultipartFile file) {
        try {
            String fileName = generateFileName(file.getOriginalFilename());
            Path targetPath = imageUploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            // 이미지 URL 생성 및 반환 (로컬 파일 시스템 경로)
            String imageUrl = targetPath.toAbsolutePath().toString();
            return imageUrl;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image to local file system", e);
        }
    }

    private String generateFileName(String originalFileName) {
        // 파일 이름을 무작위 UUID로 생성
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return UUID.randomUUID() + extension;
    }
}
