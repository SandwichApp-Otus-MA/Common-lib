package com.sandwich.app.models.model.restaurant.menu;

import com.sandwich.app.models.pagination.AdvancedFieldFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class MenuFilter {

    private AdvancedFieldFilter<UUID> id;
    private AdvancedFieldFilter<String> name;

}
