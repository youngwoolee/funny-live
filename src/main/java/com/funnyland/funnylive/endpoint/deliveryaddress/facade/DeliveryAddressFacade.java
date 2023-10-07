package com.funnyland.funnylive.endpoint.deliveryaddress.facade;

import java.util.List;
import java.util.stream.Collectors;

import com.funnyland.funnylive.domain.DeliveryAddress;
import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.endpoint.deliveryaddress.request.DeliveryAddressRequest;
import com.funnyland.funnylive.endpoint.deliveryaddress.response.DeliveryAddressResponse;
import com.funnyland.funnylive.service.DeliveryAddressService;
import com.funnyland.funnylive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DeliveryAddressFacade {

    private final DeliveryAddressService deliveryAddressService;
    private final UserService userService;


    public DeliveryAddressResponse createDeliveryAddress(Long userId, DeliveryAddressRequest deliveryAddressRequest) {
        User user = userService.getUser(userId);
        DeliveryAddress savedDeliveryAddress = deliveryAddressService.createDeliveryAddress(user, deliveryAddressRequest.toDomain());
        return DeliveryAddressResponse.of(savedDeliveryAddress);
    }


    public List<DeliveryAddressResponse> getDeliveryAddressList(Long userId) {
        User user = userService.getUser(userId);
        List<DeliveryAddress> findDeliveryAddressList = deliveryAddressService.getDeliveryAddressList(user);
        return findDeliveryAddressList.stream()
                .map(DeliveryAddressResponse::of)
                .collect(Collectors.toList());
    }

    public DeliveryAddressResponse getDeliveryAddress(Long userId, Long deliveryAddressId) {
        User user = userService.getUser(userId);
        DeliveryAddress findDeliveryAddress = deliveryAddressService.getDeliveryAddress(user, deliveryAddressId);
        return DeliveryAddressResponse.of(findDeliveryAddress);
    }

    public void deleteDeliveryAddress(Long userId, Long deliveryAddressId) {
        User user = userService.getUser(userId);
        deliveryAddressService.deleteDeliveryAddress(user, deliveryAddressId);
    }
}
