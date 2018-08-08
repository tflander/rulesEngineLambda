package dddSecondRefactor;

import java.util.ArrayList;
import java.util.List;

public class RulesEngine {

    final private static List<Rule> rules = new ArrayList<>();

    static {
        rules.add(new Rule(data -> data.getAge() <= 2, RulesEngine::processDataForBaby));
        rules.add(new Rule(data -> 3 <= data.getAge() && data.getAge() <= 5, RulesEngine::processDataForToddler));
        rules.add(new Rule(data -> data.getAge() >= 6, RulesEngine::processDataForHuman));
    }

    public String resultFor(Data data) {

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
