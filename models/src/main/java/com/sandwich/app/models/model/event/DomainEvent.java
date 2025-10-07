package com.sandwich.app.models.model.event;

import java.util.UUID;

public interface DomainEvent extends Event {
    UUID getId();
}
