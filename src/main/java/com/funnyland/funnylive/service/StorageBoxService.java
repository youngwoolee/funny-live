package com.funnyland.funnylive.service;

import java.util.ArrayList;
import java.util.List;

import com.funnyland.funnylive.endpoint.storagebox.response.StorageBoxResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StorageBoxService {

    public List<StorageBoxResponse> getStorageBoxes() {
        return new ArrayList<>();
    }
}
