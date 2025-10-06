package com.sandwich.app.models.model.order;

import com.sandwich.app.models.model.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class OrderDto {
    private UUID id;
    @NotNull
    private UUID userId;
    @NotNull
    @PositiveOrZero
    private BigDecimal amount;
    private OrderStatus status;
    private UUID restaurantId;
    private String restaurantComment;
    @Size(min = 1)
    private List<OrderItem> positions = Collections.emptyList();
    private UUID deliveryId;
    private String deliveryAddress;
    private String deliveryComment;
}