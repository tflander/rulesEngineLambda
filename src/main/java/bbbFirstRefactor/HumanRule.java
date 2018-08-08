package bbbFirstRefactor;

import java.util.function.Predicate;

public class HumanRule implements Rule {

    @Override
    public Predicate<Data> testPredicate() {
        System.out.println("returning test predicate for human");
        return data -> data.getAge() >= 6;
    }

    @Override
    public String apply(Data data) {
        System.out.println("Processing data using HumanRule...");
        return "Human";
    }
}
