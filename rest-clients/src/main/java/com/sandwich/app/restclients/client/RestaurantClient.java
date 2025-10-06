package com.sandwich.app.restclients.client;

import com.sandwich.app.models.model.restaurant.restaurant.RestaurantOrderRequest;
import com.sandwich.app.models.model.restaurant.restaurant.RestaurantOrderResponse;
import com.sandwich.app.restclients.configuration.RestClientFactory;
import com.sandwich.app.restclients.properties.RestaurantProperties;

import java.util.UUID;

public class RestaurantClient extends AbstractClient<RestaurantProperties> {

    public RestaurantClient(RestaurantProperties properties, RestClientFactory restClientFactory) {
        super(properties, restClientFactory);
    }

    public RestaurantOrderResponse create(RestaurantOrderRequest restaurantOrderDto) {
        return restClient
            .post()
            .uri(properties.getEndpoints().getCreate())
            .body(restaurantOrderDto)
            .retrieve()
            .body(RestaurantOrderResponse.class);
    }

    public void cancel(UUID restaurantId, UUID orderId) {
        restClient
            .post()
            .uri(properties.getEndpoints().getCancel(), restaurantId, orderId)
            .retrieve()
            .toBodilessEntity();
    }
}
