package cccFirstRefactor;

import java.util.function.Predicate;

public interface Processor {

    Predicate<Data> testPredicate();

    String executeAndReturnResult(Data data);
}
