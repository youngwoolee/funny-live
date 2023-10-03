package com.funnyland.funnylive.endpoint.product.facade;

import com.funnyland.funnylive.domain.Product;
import com.funnyland.funnylive.endpoint.product.request.ProductRequest;
import com.funnyland.funnylive.endpoint.product.response.ProductResponse;
import com.funnyland.funnylive.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductService productService;
    
    public Page<ProductResponse> getProducts(Pageable pageable) {
        Page<Product> products = productService.getProducts(pageable);
        return products.map(ProductResponse::of);
        
    }

    public ProductResponse getProduct(Long productId) {
        Product findProduct = productService.getProduct(productId);
        return ProductResponse.of(findProduct);
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product savedProduct = productService.createProduct(request.toDomain());
        return ProductResponse.of(savedProduct);
    }

    public ProductResponse updateProduct(Long productId, ProductRequest request) {
        Product savedProduct = productService.updateProduct(productId, request);
        return ProductResponse.of(savedProduct);
    }

    public String uploadImage(MultipartFile file) {
        return productService.uploadImage(file);
    }

    public ProductResponse active(Long productId) {
        Product savedProduct = productService.active(productId);
        return ProductResponse.of(savedProduct);
    }

    public ProductResponse inActive(Long productId) {
        Product savedProduct = productService.inActive(productId);
        return ProductResponse.of(savedProduct);
    }
}
