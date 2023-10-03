package com.funnyland.funnylive.endpoint.product.request;

import com.funnyland.funnylive.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private String imageURL;
    private String productType;

    public Product toDomain() {
        Product product = Product.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .imageURL(this.imageURL)
                .productType(this.productType)
                .build();
        return product;
    }

}