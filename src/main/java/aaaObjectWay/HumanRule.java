package aaaObjectWay;

public class HumanRule implements Rule {
    @Override
    public String apply(Data data) {
        System.out.println("Processing data using HumanRule...");
        return "Human";
    }
}
