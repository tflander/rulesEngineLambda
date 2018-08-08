package bbbObjectWay;

public class ToddlerProcessor implements Processor {
    @Override
    public String execute(Data data) {
        System.out.println("Processing data using ToddlerProcessor...");
        return "Toddler";
    }
}
