package com.sandwich.app.restclients.client;

import com.sandwich.app.models.model.billing.payment.PaymentRequest;
import com.sandwich.app.models.model.billing.payment.PaymentResponse;
import com.sandwich.app.models.model.billing.user.UserAccountDto;
import com.sandwich.app.restclients.configuration.RestClientFactory;
import com.sandwich.app.restclients.properties.BillingProperties;
import org.springframework.http.HttpStatusCode;

import java.math.BigDecimal;
import java.util.UUID;

public class BillingClient extends AbstractClient<BillingProperties> {

    public BillingClient(BillingProperties properties, RestClientFactory restClientFactory) {
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

    public void deposit(UUID userId, BigDecimal amount) {
        restClient
            .post()
            .uri(properties.getEndpoints().getDeposit(), uriBuilder -> uriBuilder
                .queryParam("amount", amount)
                .build(userId))
            .retrieve()
            .onStatus(HttpStatusCode::isError, this::handleError)
            .toBodilessEntity();
    }

    public void refund(UUID userId, UUID paymentId) {
        restClient
            .post()
            .uri(properties.getEndpoints().getDeposit(), userId, paymentId)
            .retrieve()
            .onStatus(HttpStatusCode::isError, this::handleError)
            .toBodilessEntity();
    }

    public PaymentResponse createPayment(PaymentRequest request) {
        return restClient
            .post()
            .uri(properties.getEndpoints().getCreatePayment())
            .body(request)
            .retrieve()
            .onStatus(HttpStatusCode::isError, this::handleError)
            .body(PaymentResponse.class);
    }

    public PaymentResponse checkStatus(UUID paymentId) {
        return restClient
            .post()
            .uri(properties.getEndpoints().getCheckStatus(), paymentId)
            .retrieve()
            .onStatus(HttpStatusCode::isError, this::handleError)
            .body(PaymentResponse.class);
    }
}
