package cccSecondRefactor;

import java.util.function.Function;
import java.util.function.Predicate;

public class Rule {

    final public Predicate<Data> testPredicate;
    final public Function<Data, String> execute;

    public Rule(Predicate<Data> testPredicate, Function<Data, String> execute) {
        this.testPredicate = testPredicate;
        this.execute = execute;
    }
}
