package cccFirstRefactor;

import java.util.function.Predicate;

public class HumanProcessor implements Processor {

    @Override
    public Predicate<Data> testPredicate() {
        System.out.println("returning test predicate for human");
        return data -> data.getAge() >= 6;
    }

    @Override
    public String execute(Data data) {
        System.out.println("Processing data using HumanProcessor...");
        return "Human";
    }
}
