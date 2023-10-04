package com.funnyland.funnylive.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_address")
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private User user;

    private String name;
    private String recipientName;
    private String roadNameAddress;
    private String inputDetail;
    private String referenceAddress;
    private String lotNumberAddress;
    private String postalCode;
    private boolean isDefault;

    public DeliveryAddress setUser(User user) {
        this.user = user;
        return this;
    }

}
