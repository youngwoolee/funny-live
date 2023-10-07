package com.funnyland.funnylive.endpoint.deliveryaddress.controller;

import java.util.List;

import com.funnyland.funnylive.endpoint.deliveryaddress.facade.DeliveryAddressFacade;
import com.funnyland.funnylive.endpoint.deliveryaddress.request.DeliveryAddressRequest;
import com.funnyland.funnylive.endpoint.deliveryaddress.response.DeliveryAddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{deliveryAddressId}")
    public DeliveryAddressResponse getDeliveryAddress(@PathVariable Long deliveryAddressId) {
        Long userId = 1L;
        return deliveryAddressFacade.getDeliveryAddress(userId, deliveryAddressId);
    }

    @DeleteMapping("/{deliveryAddressId}")
    public ResponseEntity<String> deleteDeliveryAddress(@PathVariable Long deliveryAddressId) {
        try {
            Long userId = 1L;
            deliveryAddressFacade.deleteDeliveryAddress(userId, deliveryAddressId);
            return ResponseEntity.ok("배송지 삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("배송지 삭제에 실패했습니다. " + e.getMessage());
        }

    }
}
