package com.funnyland.funnylive.endpoint.order.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsRequest {

    List<OrderItemRequest> orders;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItemRequest {
          private Long productId;
          private int quantity;
    }
}
