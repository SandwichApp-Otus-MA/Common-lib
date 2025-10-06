package com.sandwich.app.restclients.client;

import com.sandwich.app.models.model.billing.user.UserAccountDto;
import com.sandwich.app.restclients.configuration.RestClientFactory;
import com.sandwich.app.restclients.properties.OrderProperties;

import java.util.UUID;

public class OrderClient extends AbstractClient<OrderProperties> {

    public OrderClient(OrderProperties properties, RestClientFactory restClientFactory) {
        super(properties, restClientFactory);
    }

    public UUID create(UserAccountDto userAccount) {
        return restClient
            .post()
            .uri(properties.getEndpoints().getCreate())
            .body(userAccount)
            .retrieve()
            .body(UUID.class);
    }

    public void cancel(UUID userId, UUID orderId) {
        restClient
            .post()
            .uri(properties.getEndpoints().getCancel(), userId, orderId)
            .retrieve()
            .toBodilessEntity();
    }
}
