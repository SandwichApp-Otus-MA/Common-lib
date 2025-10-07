package com.sandwich.app.models.model.delivery;

import com.sandwich.app.models.pagination.AdvancedFieldFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class DeliveryFilter {
    private AdvancedFieldFilter<UUID> id;
    private AdvancedFieldFilter<UUID> orderId;
    private AdvancedFieldFilter<UUID> restaurantId;
}
