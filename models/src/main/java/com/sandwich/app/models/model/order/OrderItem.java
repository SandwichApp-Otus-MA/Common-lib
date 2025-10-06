package com.sandwich.app.models.model.order;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class OrderItem {
    private UUID id;
}
