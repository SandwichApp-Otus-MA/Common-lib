package com.sandwich.app.restclients.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryProperties implements ClientProperties {

    private String url;

    private Endpoints endpoints;

    @Getter
    @Setter
    public static class Endpoints {
        private String search = "/v1/delivery/search";
        private String create = "/v1/delivery/create";
        private String cancel = "/v1/delivery/cancel/{deliveryId}/{orderId}";
    }
}
