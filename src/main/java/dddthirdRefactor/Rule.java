package dddthirdRefactor;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Rule {

    final public Predicate<Data> testPredicate;
    final public Supplier<String> result;

    public Rule(Predicate<Data> testPredicate, Supplier<String> result) {
        this.testPredicate = testPredicate;
        this.result = result;
    }

    public static RuleBuilder create() {
        return new RuleBuilder();
    }
}
