package com.sandwich.app.restservices.configuration;

import com.sandwich.app.restclients.configuration.RestClientConfig;
import com.sandwich.app.restclients.model.BillingClient;
import com.sandwich.app.restclients.properties.RestClientProperties;
import com.sandwich.app.restservices.service.BillingService;
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
    @ConditionalOnBean
    public BillingService billingClient(BillingClient billingClient) {
        return new BillingService(billingClient);
    }

}
