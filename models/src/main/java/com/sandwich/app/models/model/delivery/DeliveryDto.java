package com.sandwich.app.models.model.delivery;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class DeliveryDto {
    private UUID id;
    @NotNull
    private UUID userId;
    private UUID orderId;
    private UUID restaurantId;
    private String deliveryAddress;
    private String comment;
}
