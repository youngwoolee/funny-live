package com.funnyland.funnylive.repository;

import java.util.List;
import java.util.Optional;

import com.funnyland.funnylive.domain.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {

    List<DeliveryAddress> findByUserId(Long userId);
    Optional<DeliveryAddress> findByIdAndUserId(Long id, Long userId);

    Optional<DeliveryAddress> deleteByIdAndUserId(Long id, Long userId);

}
