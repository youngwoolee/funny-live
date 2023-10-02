package com.funnyland.funnylive.service;

import org.springframework.web.multipart.MultipartFile;


public interface ImageStorageService {
    String upload(MultipartFile file);
}
