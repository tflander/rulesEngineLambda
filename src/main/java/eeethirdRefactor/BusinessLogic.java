package eeethirdRefactor;

import model.Data;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {

    public List<Rule> getRules() {
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(new Rule(data -> isAgeInRange(data, 0, 2), ProcessorFunctions::processDataForBaby));
        rules.add(new Rule(data -> isAgeInRange(data, 3, 5), ProcessorFunctions::processDataForToddler));
        rules.add(new Rule(data -> isAgeInRange(data, 6, Integer.MAX_VALUE), ProcessorFunctions::processDataForHuman));
        return rules;
    }

    private static boolean isAgeInRange(Data data, int lower, int upper) {
        return lower <= data.getAge() && data.getAge() <= upper;
    }

}
