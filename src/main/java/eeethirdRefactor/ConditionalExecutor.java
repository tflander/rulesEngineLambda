package eeethirdRefactor;


import java.util.function.Function;
import java.util.function.Predicate;

public class ConditionalExecutor<T, R> {

    final public Predicate<T> conditionToExecute;
    final public Function<T, R> execute;

    public ConditionalExecutor(Predicate<T> conditionToExecute, Function<T, R> execute) {
        this.conditionToExecute = conditionToExecute;
        this.execute = execute;
    }

}
