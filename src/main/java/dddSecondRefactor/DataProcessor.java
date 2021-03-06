package dddSecondRefactor;

import model.Data;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    final private static List<Rule> rules = new ArrayList<>();

    static {
        rules.add(new Rule(data -> data.getAge() <= 2, DataProcessor::processDataForBaby));
        rules.add(new Rule(data -> 3 <= data.getAge() && data.getAge() <= 5, DataProcessor::processDataForToddler));
        rules.add(new Rule(data -> data.getAge() >= 6, DataProcessor::processDataForHuman));
    }

    public String executeAndReturnResult(Data data) {

        return rules.stream()
                .filter(rule -> rule.testPredicate.test(data))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching rule for data: " + data))
                .execute.apply(data);
    }

    private static String processDataForBaby(Data data) {
        System.out.println("Processing data for baby...");
        return "Baby";
    }

    private static String processDataForToddler(Data data) {
        System.out.println("Processing data for toddler...");
        return "Toddler";
    }

    private static String processDataForHuman(Data data) {
        System.out.println("Processing data for human...");
        return "Human";
    }

}
