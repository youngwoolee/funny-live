package com.funnyland.funnylive.endpoint.order.controller;

import java.util.Optional;

import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.endpoint.order.request.OrderItemsRequest;
import com.funnyland.funnylive.repository.UserRepository;
import com.funnyland.funnylive.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderItemsRequest orderItemsRequest) {
        try {
            Optional<User> findUser = userRepository.findById(1L);
            orderService.placeOrder(findUser.get(), orderItemsRequest);
            return ResponseEntity.ok("주문 생성 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("주문 생성에 실패했습니다. " + e.getMessage());
        }
    }
}
