package com.sandwich.app.restclients.client;

import com.sandwich.app.models.model.delivery.DeliveryDto;
import com.sandwich.app.models.model.delivery.DeliveryFilter;
import com.sandwich.app.models.model.event.NotificationEvent;
import com.sandwich.app.models.pagination.PageData;
import com.sandwich.app.models.pagination.PaginationRequest;
import com.sandwich.app.restclients.configuration.RestClientFactory;
import com.sandwich.app.restclients.properties.DeliveryProperties;
import org.springframework.core.ParameterizedTypeReference;

import java.util.UUID;

public class DeliveryClient extends AbstractClient<DeliveryProperties> {

    public DeliveryClient(DeliveryProperties properties, RestClientFactory restClientFactory) {
        super(properties, restClientFactory);
    }

    public PageData<DeliveryDto> search(PaginationRequest<DeliveryFilter> request) {
        return restClient
            .post()
            .uri(properties.getEndpoints().getSearch())
            .body(request)
            .retrieve()
            .body(new ParameterizedTypeReference<>() {
            });
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

    public void notify(NotificationEvent event) {
        restClient
            .post()
            .uri(properties.getEndpoints().getNotify(), event)
            .retrieve()
            .toBodilessEntity();
    }
}
