package cccFirstRefactor;

import model.Data;

import java.util.function.Predicate;

public class ToddlerProcessor implements Processor {

    @Override
    public Predicate<Data> testPredicate() {
        System.out.println("returning test predicate for toddler");
        return data -> 3 <= data.getAge() && data.getAge() <= 5;
    }

    @Override
    public String executeAndReturnResult(Data data) {
        System.out.println("Processing data using ToddlerProcessor...");
        return "Toddler";
    }
}
