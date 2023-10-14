package com.funnyland.funnylive.service;

import java.util.List;
import java.util.stream.Collectors;

import com.funnyland.funnylive.domain.Product;
import com.funnyland.funnylive.domain.StorageBox;
import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.endpoint.storagebox.response.StorageBoxResponse;
import com.funnyland.funnylive.repository.ProductRepository;
import com.funnyland.funnylive.repository.StorageBoxRepository;
import com.funnyland.funnylive.repository.UserRepository;
import com.funnyland.funnylive.service.dto.StorageBoxDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StorageBoxService {

    private final StorageBoxRepository storageBoxRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<StorageBoxResponse> getStorageBoxes() {
        return storageBoxRepository.findAll().stream().map(StorageBoxResponse::of).collect(Collectors.toList());
    }

    public StorageBox addStorageBoxes(StorageBoxDto storageBoxDto) {
        Product findProduct = productRepository.findById(storageBoxDto.getProductId()).orElseThrow(() -> new RuntimeException("product not exist"));
        User findUser = userRepository.findById(storageBoxDto.getUserId()).orElseThrow(() -> new RuntimeException("user not exist"));
        StorageBox storageBox = new StorageBox();
        storageBox.addProduct(findUser, findProduct);
        return storageBoxRepository.save(storageBox);
    }

    public StorageBoxResponse getStorageBox(Long storageBoxId) {
        StorageBox findStorageBox = storageBoxRepository.findById(storageBoxId)
                .orElseThrow(() -> new RuntimeException("storageBox not exist"));

        return StorageBoxResponse.of(findStorageBox);
    }
}
