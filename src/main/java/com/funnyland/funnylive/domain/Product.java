package com.funnyland.funnylive.domain;

import com.funnyland.funnylive.endpoint.product.request.ProductRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imageURL;
    private boolean active;

    private String productType; // "popular" 또는 "open_market" 등

    public Product edit(ProductRequest productRequest) {
        this.name = productRequest.getName();
        this.description = productRequest.getDescription();
        this.price = productRequest.getPrice();
        this.imageURL = productRequest.getImageURL();
        return this;
    }

    public Product active() {
        this.active = true;
        return this;
    }

    public Product inActive() {
        this.active = false;
        return this;
    }
}
