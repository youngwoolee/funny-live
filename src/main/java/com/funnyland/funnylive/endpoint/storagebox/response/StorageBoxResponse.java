package com.funnyland.funnylive.endpoint.storagebox.response;

import com.funnyland.funnylive.domain.StorageBox;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageBoxResponse {

    private Long storageBoxId;

    private Long productId;
    private String productName;

    private Long userId;
    private String userName;

    public static StorageBoxResponse of(StorageBox storageBox) {
        return StorageBoxResponse.builder()
                .storageBoxId(storageBox.getId())
                .productId(storageBox.getProduct().getId())
                .productName(storageBox.getProduct().getName())
                .userId(storageBox.getUser().getId())
                .userName(storageBox.getUser().getUsername())
                .build();
    }

}
