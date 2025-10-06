package com.sandwich.app.restclients.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProperties implements ClientProperties {

    private String url;

    private Endpoints endpoints;

    @Getter
    @Setter
    public static class Endpoints {
        private String create = "/v1/order/create";
        private String cancel = "/v1/order/cancel/{userId}/{id}";
    }
}
