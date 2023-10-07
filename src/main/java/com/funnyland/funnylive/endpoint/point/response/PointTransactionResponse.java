package com.funnyland.funnylive.endpoint.point.response;

import java.time.LocalDateTime;

import com.funnyland.funnylive.domain.PointTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PointTransactionResponse {

    private Long pointTransactionId;
    private String transactionType;
    private int amount;
    private LocalDateTime createdAt;

    public static PointTransactionResponse of(PointTransaction pointTransaction) {
        return PointTransactionResponse.builder()
                .pointTransactionId(pointTransaction.getId())
                .transactionType(pointTransaction.getTransactionType().getName())
                .amount(pointTransaction.getAmount())
                .createdAt(pointTransaction.getCreatedAt())
                .build();
    }
}
