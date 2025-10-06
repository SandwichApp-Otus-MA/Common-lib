package com.sandwich.app.restservices.service;

import com.sandwich.app.models.model.billing.user.UserAccountDto;
import com.sandwich.app.restclients.client.OrderClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class OrderRestService {

    private final OrderClient client;

    public UUID create(UserAccountDto userAccountDto) {
        log.info("Создание нового заказа для userId: {}", userAccountDto.getUserId());
        return client.create(userAccountDto);
    }

    public void cancel(UUID userId, UUID orderId) {
        log.info("Отмена заказа для userId: {}, orderId: {}", userId, orderId);
        client.cancel(userId, orderId);
    }
}
