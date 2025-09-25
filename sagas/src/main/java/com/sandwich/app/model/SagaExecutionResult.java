package com.sandwich.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SagaExecutionResult {
    private final boolean success;
    private final List<SagaStepExecution> stepExecutions;
    private final String message;
}
