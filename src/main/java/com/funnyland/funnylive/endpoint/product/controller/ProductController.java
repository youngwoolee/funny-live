package com.funnyland.funnylive.endpoint.product.controller;

import com.funnyland.funnylive.endpoint.product.facade.ProductFacade;
import com.funnyland.funnylive.endpoint.product.request.ProductRequest;
import com.funnyland.funnylive.endpoint.product.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductFacade productFacade;

    @Operation(summary = "상품 리스트 조회", description = "상품 리스트 조회")
    @GetMapping
    public Page<ProductResponse> getProducts(Pageable pageable) {
        return productFacade.getProducts(pageable);
    }

    @GetMapping("/{productId}")
    public ProductResponse getProduct(@PathVariable Long productId) {
        return productFacade.getProduct(productId);
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest productRequest) {
        return productFacade.createProduct(productRequest);
    }

    @PutMapping("/{productId}")
    public ProductResponse update(@PathVariable Long productId, @RequestBody ProductRequest productRequest) {
        return productFacade.updateProduct(productId, productRequest);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String imageUrl = productFacade.uploadImage(file);
        return ResponseEntity.ok(imageUrl);
    }

    @PutMapping("/{productId}/active")
    public ProductResponse active(@PathVariable Long productId) {
        return productFacade.active(productId);
    }

    @PutMapping("/{productId}/inactive")
    public ProductResponse inActive(@PathVariable Long productId) {
        return productFacade.inActive(productId);
    }


}
