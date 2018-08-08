package cccFirstRefactor;

import java.util.function.Predicate;

public interface Processor {

    Predicate<Data> testPredicate();

    String execute(Data data);
}
