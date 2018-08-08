package bbbFirstRefactor;

import java.util.function.Predicate;

public class BabyRule implements Rule {

    @Override
    public Predicate<Data> testPredicate() {
        System.out.println("returning test predicate for baby");
        return data -> data.getAge() <= 2;
    }

    @Override
    public String apply(Data data) {
        return "Baby";
    }
}
