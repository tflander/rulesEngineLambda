package bbbObjectWay;

public class ToddlerRule implements Rule {
    @Override
    public String apply(Data data) {
        System.out.println("Processing data using ToddlerRule...");
        return "Toddler";
    }
}
