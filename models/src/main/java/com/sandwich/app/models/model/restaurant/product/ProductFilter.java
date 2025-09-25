package com.sandwich.app.models.model.restaurant.product;

import com.sandwich.app.models.pagination.AdvancedFieldFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProductFilter {

    private AdvancedFieldFilter<UUID> id;
    private AdvancedFieldFilter<String> name;
}