package com.funnyland.funnylive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum PointTransactionType {
    CHARGE("충전"),
    USE("사용"),
    REFUND("환불");

    private String name;
}
