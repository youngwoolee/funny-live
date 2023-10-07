package com.funnyland.funnylive.service;

import java.util.List;

import com.funnyland.funnylive.domain.DeliveryAddress;
import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.repository.DeliveryAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class DeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;

    @Transactional
    public DeliveryAddress createDeliveryAddress(User user, DeliveryAddress deliveryAddress) {
       //TODO: 대표 배송지 변경
        DeliveryAddress deliveryAddressWithUser = deliveryAddress.setUser(user);
        return deliveryAddressRepository.save(deliveryAddressWithUser);
    }

    public List<DeliveryAddress> getDeliveryAddressList(User user) {
        List<DeliveryAddress> findDeliveryAddressList = deliveryAddressRepository.findByUserId(user.getId());
        return findDeliveryAddressList;
    }

    public DeliveryAddress getDeliveryAddress(User user, Long deliveryAddressId) {
        return deliveryAddressRepository.findByIdAndUserId(deliveryAddressId, user.getId())
                .orElseThrow(() -> new RuntimeException("deliveryAddress not exist"));
    }

    @Transactional
    public void deleteDeliveryAddress(User user, Long deliveryAddressId) {
        DeliveryAddress findDeliveryAddress = deliveryAddressRepository.findByIdAndUserId(deliveryAddressId, user.getId())
                .orElseThrow(() -> new RuntimeException("deliveryAddress not exist"));

        deliveryAddressRepository.delete(findDeliveryAddress);
    }
}
