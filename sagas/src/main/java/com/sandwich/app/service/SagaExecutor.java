package com.sandwich.app.service;

import com.sandwich.app.model.SagaExecutionResult;
import com.sandwich.app.model.SagaStep;
import com.sandwich.app.model.SagaStepExecution;
import com.sandwich.app.model.SagaStepResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SagaExecutor {

    public <T> SagaExecutionResult executeSaga(SagaDefinition<T> saga, T data) {
        List<SagaStepExecution> executions = new ArrayList<>();
        SagaStep<T> failedStep = null;

        // Прямое выполнение шагов
        for (SagaStep<T> step : saga.getSteps()) {
            try {
                log.info("Executing saga step: {}", step.getName());
                var result = execute(data, step);
                executions.add(new SagaStepExecution(step.getName(), result, false));

                if (result == SagaStepResult.FAILURE) {
                    failedStep = step;
                    break;
                }
            } catch (Exception e) {
                log.error("Error executing step: {}", step.getName(), e);
                executions.add(new SagaStepExecution(step.getName(), SagaStepResult.FAILURE, false));
                failedStep = step;
                break;
            }
        }

        if (failedStep != null) {
            return compensateSaga(saga, data, executions, failedStep);
        }

        return new SagaExecutionResult(true, executions, "Saga completed successfully");
    }

    private <T> SagaExecutionResult compensateSaga(SagaDefinition<T> saga, T data,
                                                   List<SagaStepExecution> executions,
                                                   SagaStep<T> failedStep) {
        var failedStepIndex = saga.getSteps().indexOf(failedStep);
        var stepsToCompensate = saga.getSteps()
            .subList(0, failedStepIndex)
            .stream()
            .sorted((s1, s2) -> Integer.compare(saga.getSteps().indexOf(s2), saga.getSteps().indexOf(s1)))
            .toList();

        for (var step : stepsToCompensate) {
            try {
                log.info("Compensating step: {}", step.getName());
                var result = executeCompensate(data, step);
                executions.add(new SagaStepExecution(step.getName(), result, true));

                if (result == SagaStepResult.COMPENSATION_FAILED) {
                    return new SagaExecutionResult(false, executions, "Compensation failed for step: " + step.getName());
                }
            } catch (Exception e) {
                log.error("Error compensating step: {}", step.getName(), e);
                executions.add(new SagaStepExecution(step.getName(), SagaStepResult.COMPENSATION_FAILED, true));
                return new SagaExecutionResult(false, executions, "Compensation error for step: " + step.getName());
            }
        }

        return new SagaExecutionResult(false, executions,
            "Saga failed but compensation completed");
    }

    private <T> SagaStepResult execute(T data, SagaStep<T> step) {
        try {
            return step.execute(data);
        } catch (Exception ex) {
            log.error("При выполнении шага: {}", step.getName(), ex);
            return SagaStepResult.FAILURE;
        }
    }

    private <T> SagaStepResult executeCompensate(T data, SagaStep<T> step) {
        try {
            return step.compensate(data);
        } catch (Exception ex) {
            log.error("При выполнении компенсирующего шага: {}", step.getName(), ex);
            return SagaStepResult.COMPENSATION_FAILED;
        }
    }
}
