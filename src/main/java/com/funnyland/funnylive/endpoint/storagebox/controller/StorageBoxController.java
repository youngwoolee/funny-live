package com.funnyland.funnylive.endpoint.storagebox.controller;

import java.util.List;

import com.funnyland.funnylive.endpoint.storagebox.response.StorageBoxResponse;
import com.funnyland.funnylive.service.StorageBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/storage-boxes")
public class StorageBoxController {

    private final StorageBoxService storageBoxService;

    @GetMapping
    public List<StorageBoxResponse> getStorageBoxes() {
        return storageBoxService.getStorageBoxes();
    }

}
