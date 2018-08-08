package dddthirdRefactor;

import java.util.ArrayList;
import java.util.List;

public class RulesEngine {

    final private static List<Rule> rules = new ArrayList<>();

    static {
        rules.add(new Rule(data -> isAgeInRange(data, 0, 2), RulesEngine::processDataForBaby));
        rules.add(new Rule(data -> isAgeInRange(data, 3, 5), RulesEngine::processDataForToddler));
        rules.add(new Rule(data -> isAgeInRange(data, 6, Integer.MAX_VALUE), RulesEngine::processDataForHuman));
    }

    public String resultFor(Data data) {

        return rules.stream()
                .filter(rule -> rule.testPredicate.test(data))
                .findFirst()
                .orElseThrow(RuntimeException::new)
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

    private static boolean isAgeInRange(Data data, int lower, int upper) {
        return lower <= data.getAge() && data.getAge() <= upper;
    }
}
