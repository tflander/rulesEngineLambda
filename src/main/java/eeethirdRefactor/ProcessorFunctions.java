package eeethirdRefactor;

import model.Data;

import java.util.function.Function;

public class ProcessorFunctions {

    public String processDataForBaby(Data data) {
        System.out.println("Processing data for baby...");
        return "Baby";
    };

    public String processDataForToddler(Data data) {
        System.out.println("Processing data for toddler...");
        return "Toddler";
    };

    public String processDataForHuman(Data data)  {
        System.out.println("Processing data for human...");
        return "Human";
    };

}
