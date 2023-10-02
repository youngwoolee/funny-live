package com.funnyland.funnylive.repository;

import com.funnyland.funnylive.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
