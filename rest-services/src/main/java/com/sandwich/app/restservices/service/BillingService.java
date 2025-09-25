package com.sandwich.app.restservices.service;

import com.sandwich.app.restclients.model.BillingClient;
import com.sandwich.app.models.model.billing.payment.PaymentRequest;
import com.sandwich.app.models.model.billing.payment.PaymentResponse;
import com.sandwich.app.models.model.billing.user.UserAccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillingService {

    private final BillingClient billingClient;

    public void create(UserAccountDto userAccountDto) {
        log.info("Создание нового аккаунта для userId: {}", userAccountDto.getUserId());
        billingClient.create(userAccountDto);
    }

    public void deposit(UUID userId, BigDecimal amount) {
        log.info("Попытка вернуть денеги за заказ для userId: {}", userId);
        billingClient.deposit(userId, amount);
    }

    public PaymentResponse createPayment(PaymentRequest request) {
        log.info("Попытка провести оплату для userId: {}", request.getUserId());
        return billingClient.createPayment(request);
    }

    public PaymentResponse checkPaymentStatus(UUID paymentId) {
        log.info("Попытка проверить статус платежа: {}", paymentId);
        return billingClient.checkStatus(paymentId);
    }
}
