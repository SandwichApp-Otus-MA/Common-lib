package com.sandwich.app.models.model.event;

import com.sandwich.app.models.model.enums.EventType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Map;

@Data
@Accessors(chain = true)
public class NotificationEvent implements Event {
    private EventType eventType;
    private String operation;
    private String message;
    private Map<String, Object> data;
    private Instant timestamp =  Instant.now();
}
