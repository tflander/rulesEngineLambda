package bbbFirstRefactor;

import java.util.function.Predicate;

public interface Rule {

    Predicate<Data> testPredicate();

    String apply();
}
