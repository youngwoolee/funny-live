package com.funnyland.funnylive.endpoint.deliveryaddress.controller;

import java.util.List;

import com.funnyland.funnylive.endpoint.deliveryaddress.facade.DeliveryAddressFacade;
import com.funnyland.funnylive.endpoint.deliveryaddress.request.DeliveryAddressRequest;
import com.funnyland.funnylive.endpoint.deliveryaddress.response.DeliveryAddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery-address")
public class DeliveryAddressController {

    private final DeliveryAddressFacade deliveryAddressFacade;

    @PostMapping
    public DeliveryAddressResponse createDeliveryAddress(@RequestBody DeliveryAddressRequest deliveryAddressRequest) {
        Long userId = 1L;
        return deliveryAddressFacade.createDeliveryAddress(userId, deliveryAddressRequest);
    }

    @GetMapping
    public List<DeliveryAddressResponse> getDeliveryAddressList() {
        Long userId = 1L;
        return deliveryAddressFacade.getDeliveryAddressList(userId);
    }
}
