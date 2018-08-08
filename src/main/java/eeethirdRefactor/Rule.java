package eeethirdRefactor;


import model.Data;

import java.util.function.Function;
import java.util.function.Predicate;

public class Rule<T> {

    final public Predicate<Data> testPredicate;
    final public Function<Data, T> execute;

    public Rule(Predicate<Data> testPredicate, Function<Data, T> execute) {
        this.testPredicate = testPredicate;
        this.execute = execute;
    }

}
