package com.funnyland.funnylive.repository;

import com.funnyland.funnylive.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
