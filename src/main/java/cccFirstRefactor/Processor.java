package cccFirstRefactor;

import model.Data;

import java.util.function.Predicate;

public interface Processor {

    Predicate<Data> testPredicate();

    String executeAndReturnResult(Data data);
}
