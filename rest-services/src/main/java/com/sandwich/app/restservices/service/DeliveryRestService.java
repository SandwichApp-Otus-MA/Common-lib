package com.sandwich.app.restservices.service;

import com.sandwich.app.models.model.delivery.DeliveryDto;
import com.sandwich.app.restclients.client.DeliveryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class DeliveryRestService {

    private final DeliveryClient client;

    public UUID create(DeliveryDto deliveryDto) {
        log.info("Создание заявки на доставку для userId: {}", deliveryDto.getUserId());
        return client.create(deliveryDto);
    }

    public void cancel(UUID deliveryId, UUID orderId) {
        log.info("Отмена доставки deliveryId: {}, orderId: {}", deliveryId, orderId);
        client.cancel(deliveryId, orderId);
    }
}
