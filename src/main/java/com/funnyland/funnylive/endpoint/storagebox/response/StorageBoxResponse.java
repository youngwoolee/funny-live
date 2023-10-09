package com.funnyland.funnylive.endpoint.storagebox.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StorageBoxResponse {

    private Long storageBoxId;

    private Long productId;
    private String productName;

    private Long userId;
    private String userName;

}
