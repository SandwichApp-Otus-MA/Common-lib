package com.sandwich.app.restservices.service;

import com.sandwich.app.models.model.delivery.DeliveryDto;
import com.sandwich.app.models.model.delivery.DeliveryFilter;
import com.sandwich.app.models.pagination.PageData;
import com.sandwich.app.models.pagination.PaginationRequest;
import com.sandwich.app.restclients.client.DeliveryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class DeliveryRestService {

    private final DeliveryClient client;

    public PageData<DeliveryDto> search(PaginationRequest<DeliveryFilter> request) {
        return client.search(request);
    }

    public UUID create(DeliveryDto deliveryDto) {
        log.info("Создание заявки на доставку для orderId: {}", deliveryDto.getOrderId());
        return client.create(deliveryDto);
    }

    public void cancel(UUID deliveryId, UUID orderId) {
        log.info("Отмена доставки deliveryId: {}, orderId: {}", deliveryId, orderId);
        client.cancel(deliveryId, orderId);
    }
}
