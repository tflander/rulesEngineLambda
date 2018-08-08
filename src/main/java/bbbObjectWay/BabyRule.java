package bbbObjectWay;

public class BabyRule implements Rule {
    @Override
    public String apply(Data data) {
        System.out.println("Processing data using BabyRule...");
        return "Baby";
    }
}
