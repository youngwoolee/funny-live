package com.funnyland.funnylive.service;

import com.funnyland.funnylive.domain.Product;
import com.funnyland.funnylive.endpoint.product.request.ProductRequest;
import com.funnyland.funnylive.endpoint.product.response.ProductResponse;
import com.funnyland.funnylive.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ImageStorageService imageStorageService;

    public Page<ProductResponse> getProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductResponse::of);
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

    public String uploadImage(MultipartFile file) {
        return imageStorageService.upload(file);
    }

    public ProductResponse getProduct(Long productId) {
        return productRepository.findById(productId)
                .map(ProductResponse::of)
                .orElseThrow(() -> new RuntimeException("Product not exist"));
    }

    @Transactional
    public ProductResponse updateProduct(Long productId, ProductRequest productRequest) {
        return productRepository.findById(productId)
                .map(product -> product.edit(productRequest))
                .map(ProductResponse::of)
                .orElseThrow(() -> new RuntimeException("Product not exist"));
    }

    @Transactional
    public ProductResponse active(Long productId) {
        return productRepository.findById(productId)
                .map(Product::active)
                .map(ProductResponse::of)
                .orElseThrow(() -> new RuntimeException("Product not exist"));
    }

    @Transactional
    public ProductResponse inActive(Long productId) {
        return productRepository.findById(productId)
                .map(Product::inActive)
                .map(ProductResponse::of)
                .orElseThrow(() -> new RuntimeException("Product not exist"));
    }
}
