package aaaBruteForce;

public class DataProcessor {
    public String process(Data data) {

        if(data.getAge() <= 2) {
            System.out.println("Processing data for baby...");
            return "Baby";
        } else if(data.getAge() <= 5) {
            System.out.println("Processing data for toddler...");
            return "Toddler";
        }
        System.out.println("Processing data for human...");
        return "Human";
    }
}
