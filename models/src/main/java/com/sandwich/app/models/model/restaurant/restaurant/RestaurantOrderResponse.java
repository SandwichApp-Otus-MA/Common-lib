package com.sandwich.app.models.model.restaurant.restaurant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.enums.RestaurantStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantOrderResponse {
    private UUID id;
    private RestaurantStatus status;
    private String comment;
}
