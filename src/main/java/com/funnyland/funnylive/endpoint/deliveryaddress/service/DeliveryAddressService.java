package com.funnyland.funnylive.endpoint.deliveryaddress.service;

import java.util.List;

import com.funnyland.funnylive.domain.DeliveryAddress;
import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.repository.DeliveryAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;

    public DeliveryAddress createDeliveryAddress(User user, DeliveryAddress deliveryAddress) {
       //TODO: 대표 배송지 변경
        DeliveryAddress deliveryAddressWithUser = deliveryAddress.setUser(user);
        return deliveryAddressRepository.save(deliveryAddressWithUser);
    }

    public List<DeliveryAddress> getDeliveryAddressList(User user) {
        List<DeliveryAddress> findDeliveryAddressList = deliveryAddressRepository.findByUserId(user.getId());
        return findDeliveryAddressList;
    }
}
