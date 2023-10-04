package com.funnyland.funnylive.endpoint.deliveryaddress.response;

import com.funnyland.funnylive.domain.DeliveryAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryAddressResponse {
    private String name;
    private String recipientName;
    private String roadNameAddress;
    private String inputDetail;
    private String referenceAddress;
    private String lotNumberAddress;
    private String postalCode;
    private boolean isDefault;

    public static DeliveryAddressResponse of(DeliveryAddress deliveryAddress) {
        return DeliveryAddressResponse.builder()
                .name(deliveryAddress.getName())
                .recipientName(deliveryAddress.getRecipientName())
                .roadNameAddress(deliveryAddress.getRoadNameAddress())
                .inputDetail(deliveryAddress.getInputDetail())
                .referenceAddress(deliveryAddress.getReferenceAddress())
                .lotNumberAddress(deliveryAddress.getLotNumberAddress())
                .postalCode(deliveryAddress.getPostalCode())
                .isDefault(deliveryAddress.isDefault())
                .build();
    }
}
