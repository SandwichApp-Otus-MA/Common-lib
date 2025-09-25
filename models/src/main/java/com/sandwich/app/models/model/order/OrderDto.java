package com.sandwich.app.models.model.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
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
    private BigDecimal price;
    @Size(min = 1)
    private List<UUID> positionIds;
}