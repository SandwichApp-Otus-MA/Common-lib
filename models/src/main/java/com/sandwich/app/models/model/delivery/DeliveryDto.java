package com.sandwich.app.models.model.delivery;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.enums.DeliveryStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryDto {
    private UUID id;
    private UUID orderId;
    private UUID restaurantId;
    private String address;
    private String comment;
    private DeliveryStatus status;
}
