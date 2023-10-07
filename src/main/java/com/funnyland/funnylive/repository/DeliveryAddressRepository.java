package com.funnyland.funnylive.repository;

import java.util.List;

import com.funnyland.funnylive.domain.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {

    List<DeliveryAddress> findByUserId(Long userId);
}
