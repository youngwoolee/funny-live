package com.funnyland.funnylive.service;

import com.funnyland.funnylive.domain.Product;
import com.funnyland.funnylive.endpoint.product.request.ProductRequest;
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

    public Page<Product> getProducts(Pageable pageable) {
        Page<Product> findProducts = productRepository.findAll(pageable);
        return findProducts;
    }


    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public String uploadImage(MultipartFile file) {
        return imageStorageService.upload(file);
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not exist"));
    }

    @Transactional
    public Product updateProduct(Long productId, ProductRequest productRequest) {
        return productRepository.findById(productId)
                .map(product -> product.edit(productRequest))
                .orElseThrow(() -> new RuntimeException("Product not exist"));
    }

    @Transactional
    public Product active(Long productId) {
        return productRepository.findById(productId)
                .map(Product::active)
                .orElseThrow(() -> new RuntimeException("Product not exist"));
    }

    @Transactional
    public Product inActive(Long productId) {
        return productRepository.findById(productId)
                .map(Product::inActive)
                .orElseThrow(() -> new RuntimeException("Product not exist"));
    }
}
