package com.sandwich.app.restclients.properties;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class TimeoutProperties {
    private Duration connectTimeout = Duration.ofSeconds(5);
    private Duration readTimeout = Duration.ofSeconds(30);
}
