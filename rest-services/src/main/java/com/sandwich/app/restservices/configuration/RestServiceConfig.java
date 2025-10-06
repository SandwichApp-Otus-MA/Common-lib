package com.sandwich.app.restservices.configuration;

import com.sandwich.app.restclients.client.BillingClient;
import com.sandwich.app.restclients.client.DeliveryClient;
import com.sandwich.app.restclients.client.OrderClient;
import com.sandwich.app.restclients.client.RestaurantClient;
import com.sandwich.app.restclients.configuration.RestClientConfig;
import com.sandwich.app.restclients.properties.RestClientProperties;
import com.sandwich.app.restservices.service.BillingRestService;
import com.sandwich.app.restservices.service.DeliveryRestService;
import com.sandwich.app.restservices.service.OrderRestService;
import com.sandwich.app.restservices.service.RestaurantRestService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AutoConfigureAfter(RestClientConfig.class)
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(RestClientProperties.class)
public class RestServiceConfig {

    @Bean
    @ConditionalOnBean(BillingClient.class)
    public BillingRestService billingRestService(BillingClient billingClient) {
        return new BillingRestService(billingClient);
    }

    @Bean
    @ConditionalOnBean(DeliveryClient.class)
    public DeliveryRestService deliveryRestService(DeliveryClient deliveryClient) {
        return new DeliveryRestService(deliveryClient);
    }

    @Bean
    @ConditionalOnBean(OrderClient.class)
    public OrderRestService orderRestService(OrderClient orderClient) {
        return new OrderRestService(orderClient);
    }

    @Bean
    @ConditionalOnBean(RestaurantClient.class)
    public RestaurantRestService restaurantRestService(RestaurantClient restaurantClient) {
        return new RestaurantRestService(restaurantClient);
    }

}
