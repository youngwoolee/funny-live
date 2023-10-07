package com.funnyland.funnylive.endpoint.deliveryaddress.request;

import com.funnyland.funnylive.domain.DeliveryAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddressRequest {

    private String name;
    private String phoneNumber;
    private String recipientName;
    private String roadNameAddress;
    private String inputDetail;
    private String referenceAddress;
    private String lotNumberAddress;
    private String postalCode;
    private boolean isDefault;

    public boolean getIsDefault() {
        return isDefault;
    }

    public DeliveryAddress toDomain() {
        DeliveryAddress deliveryAddress = DeliveryAddress.builder()
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .recipientName(this.recipientName)
                .roadNameAddress(this.roadNameAddress)
                .inputDetail(this.inputDetail)
                .referenceAddress(this.referenceAddress)
                .lotNumberAddress(this.lotNumberAddress)
                .postalCode(this.postalCode)
                .isDefault(this.isDefault)
                .build();
        return deliveryAddress;
    }
}
