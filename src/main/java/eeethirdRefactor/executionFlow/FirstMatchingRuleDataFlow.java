package eeethirdRefactor.executionFlow;

import java.util.List;

public class FirstMatchingRuleDataFlow<T, R> {

    private final List<ConditionalExecutor<T, R>> conditionalExecutors;

    public FirstMatchingRuleDataFlow(List<ConditionalExecutor<T, R>> conditionalExecutors) {
        this.conditionalExecutors = conditionalExecutors;
    }

    public R executeAndReturnResult(T data) {

        ConditionalExecutor<T, R> conditionalExecutorForData = conditionalExecutors.stream()
                .filter(conditionalExecutor -> conditionalExecutor.conditionToExecute.test(data))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching rule for data: " + data));

        return conditionalExecutorForData.execute.apply(data);
    }
}
