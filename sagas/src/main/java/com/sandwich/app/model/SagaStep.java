package com.sandwich.app.model;

public interface SagaStep<T> {
    String getName();
    SagaStepResult execute(T data);
    SagaStepResult compensate(T data);
}
