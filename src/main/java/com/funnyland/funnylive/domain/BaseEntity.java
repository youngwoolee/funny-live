package com.funnyland.funnylive.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;


@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime modifiedAt;
}
