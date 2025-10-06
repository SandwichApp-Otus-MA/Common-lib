package com.sandwich.app.restclients.client;

import com.sandwich.app.models.model.delivery.DeliveryDto;
import com.sandwich.app.restclients.configuration.RestClientFactory;
import com.sandwich.app.restclients.properties.DeliveryProperties;

import java.util.UUID;

public class DeliveryClient extends AbstractClient<DeliveryProperties> {

    public DeliveryClient(DeliveryProperties properties, RestClientFactory restClientFactory) {
        super(properties, restClientFactory);
    }

    public UUID create(DeliveryDto deliveryDto) {
        return restClient
            .post()
            .uri(properties.getEndpoints().getCreate())
            .body(deliveryDto)
            .retrieve()
            .body(UUID.class);
    }

    public void cancel(UUID deliveryId, UUID orderId) {
        restClient
            .post()
            .uri(properties.getEndpoints().getCancel(), deliveryId, orderId)
            .retrieve()
            .toBodilessEntity();
    }
}
