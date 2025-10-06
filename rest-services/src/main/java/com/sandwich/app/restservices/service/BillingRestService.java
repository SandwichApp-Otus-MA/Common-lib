package com.sandwich.app.restservices.service;

import com.sandwich.app.models.model.billing.payment.PaymentRequest;
import com.sandwich.app.models.model.billing.payment.PaymentResponse;
import com.sandwich.app.models.model.billing.user.UserAccountDto;
import com.sandwich.app.restclients.client.BillingClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class BillingRestService {

    private final BillingClient client;

    public UUID create(UserAccountDto userAccountDto) {
        log.info("Создание нового аккаунта для userId: {}", userAccountDto.getUserId());
        return client.create(userAccountDto);
    }

    public void deposit(UUID userId, BigDecimal amount) {
        log.info("Попытка начислить деньги для userId: {}", userId);
        client.deposit(userId, amount);
    }

    public void refund(UUID userId, UUID paymentId) {
        log.info("Попытка возврата для userId: {} и paymentId: {}", userId, paymentId);
        client.refund(userId, paymentId);
    }

    public PaymentResponse createPayment(PaymentRequest request) {
        log.info("Попытка провести оплату для userId: {}", request.getUserId());
        return client.createPayment(request);
    }

    public PaymentResponse checkPaymentStatus(UUID paymentId) {
        log.info("Попытка проверить статус платежа: {}", paymentId);
        return client.checkStatus(paymentId);
    }
}
