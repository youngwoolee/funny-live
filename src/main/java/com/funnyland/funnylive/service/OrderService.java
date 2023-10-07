package com.funnyland.funnylive.service;

import java.util.ArrayList;
import java.util.List;

import com.funnyland.funnylive.domain.Order;
import com.funnyland.funnylive.domain.OrderItem;
import com.funnyland.funnylive.domain.PointTransaction;
import com.funnyland.funnylive.domain.PointTransactionType;
import com.funnyland.funnylive.domain.Product;
import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.endpoint.order.request.OrderItemsRequest;
import com.funnyland.funnylive.repository.OrderRepository;
import com.funnyland.funnylive.repository.PointTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final PointTransactionRepository pointTransactionRepository;

    public Order placeOrder(User user, OrderItemsRequest orderItemsRequest) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemsRequest.OrderItemRequest orderItemRequest : orderItemsRequest.getOrders()) {
            Long productId = orderItemRequest.getProductId();
            int quantity = orderItemRequest.getQuantity();

            Product product = productService.getProduct(productId);

            OrderItem orderItem = new OrderItem(product, quantity);
            orderItems.add(orderItem);
        }

        Order order = new Order(user, orderItems);
        Order savedOrder = orderRepository.save(order);
        int totalPoints = calculateTotalPoints(orderItems);
        user.deductPoints(totalPoints);
        PointTransaction pointTransaction = new PointTransaction(totalPoints, user, PointTransactionType.USE);
        pointTransactionRepository.save(pointTransaction);
        return savedOrder;
    }

    private int calculateTotalPoints(List<OrderItem> orderItems) {
        // 주문 상품의 가격을 합산하여 포인트 차감 계산
        int totalPoints = 0;
        for (OrderItem orderItem : orderItems) {
            totalPoints += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }
        return totalPoints;
    }
}
