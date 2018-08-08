package cccFirstRefactor;

import java.util.function.Predicate;

public class BabyProcessor implements Processor {

    @Override
    public Predicate<Data> testPredicate() {
        System.out.println("returning test predicate for baby");
        return data -> data.getAge() <= 2;
    }

    @Override
    public String execute(Data data) {
        return "Baby";
    }
}
