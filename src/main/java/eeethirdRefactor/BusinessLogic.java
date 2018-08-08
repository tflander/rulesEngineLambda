package eeethirdRefactor;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {

    public List<Rule> getRules() {
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(new Rule(data -> isAgeInRange(data, 0, 2), BusinessLogic::processDataForBaby));
        rules.add(new Rule(data -> isAgeInRange(data, 3, 5), BusinessLogic::processDataForToddler));
        rules.add(new Rule(data -> isAgeInRange(data, 6, Integer.MAX_VALUE), BusinessLogic::processDataForHuman));
        return rules;
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
