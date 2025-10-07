package com.sandwich.app.models.model.event;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.enums.OrderStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderEvent implements DomainEvent {
    private UUID id;
    private OrderStatus status;
}
