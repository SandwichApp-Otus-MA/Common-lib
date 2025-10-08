package com.sandwich.app.models.model.restaurant.restaurant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.order.OrderItem;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantOrderRequest {
    private UUID id;
    private UUID orderId;
    private List<OrderItem> positions = Collections.emptyList();
    private String comment;
}
