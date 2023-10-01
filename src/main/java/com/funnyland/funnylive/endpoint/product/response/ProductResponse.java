package com.funnyland.funnylive.endpoint.product.response;

import com.funnyland.funnylive.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProductResponse {

    private Long productId;
    private String name;
    private String description;
    private double price;
    private String imageUrl;

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageURL())
                .build();
    }

}
