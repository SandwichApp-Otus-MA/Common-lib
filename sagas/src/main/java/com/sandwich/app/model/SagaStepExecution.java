package com.sandwich.app.model;

import lombok.Data;

import java.time.Instant;

@Data
public class SagaStepExecution {

    private final String stepName;
    private final SagaStepResult result;
    private final boolean isCompensation;
    private final Instant timestamp = Instant.now();

    public SagaStepExecution(String stepName, SagaStepResult result, boolean isCompensation) {
        this.stepName = stepName;
        this.result = result;
        this.isCompensation = isCompensation;
    }
}
