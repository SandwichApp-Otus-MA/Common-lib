package com.sandwich.app.restclients.configuration;

import com.sandwich.app.restclients.client.BillingClient;
import com.sandwich.app.restclients.client.DeliveryClient;
import com.sandwich.app.restclients.client.OrderClient;
import com.sandwich.app.restclients.client.RestaurantClient;
import com.sandwich.app.restclients.properties.RestClientProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

import java.util.List;

@Configuration
@EnableConfigurationProperties({RestClientProperties.class})
public class RestClientConfig {

    @Bean
    public RestClientFactory restClientFactory(RestClientProperties properties,
                                               RestClient.Builder builder,
                                               List<ClientHttpRequestInterceptor> interceptors) {
        return new RestClientFactory(properties, builder, interceptors);
    }

    @Bean
    @ConditionalOnProperty(prefix = "rest.clients.billing", name = "url")
    public BillingClient billingClient(RestClientProperties properties, RestClientFactory restClientFactory) {
        return new BillingClient(properties.getBilling(), restClientFactory);
    }

    @Bean
    @ConditionalOnProperty(prefix = "rest.clients.delivery", name = "url")
    public DeliveryClient deliveryClient(RestClientProperties properties, RestClientFactory restClientFactory) {
        return new DeliveryClient(properties.getDelivery(), restClientFactory);
    }

    @Bean
    @ConditionalOnProperty(prefix = "rest.clients.order", name = "url")
    public OrderClient orderClient(RestClientProperties properties, RestClientFactory restClientFactory) {
        return new OrderClient(properties.getOrder(), restClientFactory);
    }

    @Bean
    @ConditionalOnProperty(prefix = "rest.clients.restaurant", name = "url")
    public RestaurantClient restaurantClient(RestClientProperties properties, RestClientFactory restClientFactory) {
        return new RestaurantClient(properties.getRestaurant(), restClientFactory);
    }
}
