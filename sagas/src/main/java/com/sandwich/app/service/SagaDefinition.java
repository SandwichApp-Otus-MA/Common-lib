package com.sandwich.app.service;

import com.sandwich.app.model.SagaStep;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class SagaDefinition<T> {

    private final List<SagaStep<T>> steps;
    private final Map<String, SagaStep<T>> stepMap;

    public SagaDefinition(List<SagaStep<T>> steps) {
        this.steps = List.copyOf(steps);
        this.stepMap = steps.stream()
            .collect(Collectors.toMap(SagaStep::getName, Function.identity()));
    }
}
