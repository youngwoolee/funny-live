package com.funnyland.funnylive.service;

import java.util.List;
import java.util.stream.Collectors;

import com.funnyland.funnylive.domain.Product;
import com.funnyland.funnylive.endpoint.product.request.ProductRequest;
import com.funnyland.funnylive.endpoint.product.response.ProductResponse;
import com.funnyland.funnylive.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }


    public ProductResponse createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .imageURL(request.getImageURL())
                .productType(request.getProductType())
                .build();
        Product savedProduct = productRepository.save(product);
        return ProductResponse.of(savedProduct);
    }
}
