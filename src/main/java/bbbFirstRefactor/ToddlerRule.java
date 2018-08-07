package bbbFirstRefactor;

import java.util.function.Predicate;

public class ToddlerRule implements Rule {

    @Override
    public Predicate<Data> testPredicate() {
        System.out.println("returning test predicate for toddler");
        return data -> 3 <= data.getAge() && data.getAge() <= 5;
    }

    @Override
    public String apply() {
        return "Toddler";
    }
}