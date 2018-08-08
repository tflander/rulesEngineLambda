package eeethirdRefactor.executionFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

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

    static public class Builder<T1, R1> {

        private Predicate<T1> testifShouldProcess;
        private List<ConditionalExecutor<T1, R1>> conditionalExecutors = new ArrayList<>();

        public static <T1, R1> Builder<T1, R1> create() {
            return new Builder<T1, R1>();
        }

        public Builder<T1, R1> addingCondition(Predicate<T1> testifShouldProcess) {
            this.testifShouldProcess = testifShouldProcess;
            return this;
        }

        public Builder<T1, R1> toRun(Function<T1, R1> process) {
            conditionalExecutors.add(new ConditionalExecutor<>(testifShouldProcess, process));
            return this;
        }

        public FirstMatchingRuleDataFlow<T1, R1> build() {
            return new FirstMatchingRuleDataFlow<>(conditionalExecutors);
        }
    }

}
