package com.sandwich.app.models.model.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {
    private UUID id;
    private String name;
    private Float quantity;
    private BigDecimal price;
}
