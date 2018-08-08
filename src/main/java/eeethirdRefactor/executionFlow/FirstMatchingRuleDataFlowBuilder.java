package eeethirdRefactor.executionFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;

public class FirstMatchingRuleDataFlowBuilder<T,R> {

    private Predicate<T> testifShouldProcess;
    private List<ConditionalExecutor<T,R>> conditionalExecutors = new ArrayList<>();

    public static FirstMatchingRuleDataFlowBuilder create() {
        return new FirstMatchingRuleDataFlowBuilder();
    }

    public FirstMatchingRuleDataFlowBuilder addingCondition(Predicate<T> testifShouldProcess) {
        this.testifShouldProcess = testifShouldProcess;
        return this;
    }

    public FirstMatchingRuleDataFlowBuilder toRun(Function<T,R> process) {
        conditionalExecutors.add(new ConditionalExecutor<>(testifShouldProcess, process));
        return this;
    }

    public FirstMatchingRuleDataFlow<T,R> build() {
        return new FirstMatchingRuleDataFlow<>(conditionalExecutors);
    }
}
