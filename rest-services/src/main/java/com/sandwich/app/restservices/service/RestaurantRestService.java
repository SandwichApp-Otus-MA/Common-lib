package com.sandwich.app.restservices.service;

import com.sandwich.app.models.model.restaurant.restaurant.RestaurantOrderRequest;
import com.sandwich.app.models.model.restaurant.restaurant.RestaurantOrderResponse;
import com.sandwich.app.restclients.client.RestaurantClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class RestaurantRestService {

    private final RestaurantClient client;

    public RestaurantOrderResponse create(RestaurantOrderRequest restaurantOrderDto) {
        log.info("Создание заявки на приготовление еды для userId: {}", restaurantOrderDto.getUserId());
        return client.create(restaurantOrderDto);
    }

    public void cancel(UUID restaurantId, UUID orderId) {
        log.info("Отменить заказ в ресторане restaurantId: {}, orderId: {}", restaurantId, orderId);
        client.cancel(restaurantId, orderId);
    }
}
