package eeethirdRefactor;

import model.Data;

import java.util.function.Function;

public class ProcessorFunctions {

    public Function<Data, String> processDataForBaby = data -> {
        System.out.println("Processing data for baby...");
        return "Baby";
    };

    public Function<Data, String> processDataForToddler = data -> {
        System.out.println("Processing data for toddler...");
        return "Toddler";
    };

    public Function<Data, String> processDataForHuman = data ->  {
        System.out.println("Processing data for human...");
        return "Human";
    };

}
