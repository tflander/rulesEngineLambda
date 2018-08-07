package cccSecondRefactor;

import java.util.ArrayList;
import java.util.List;

public class RulesEngine {

    final private static List<Rule> rules = new ArrayList<>();

    static {
        rules.add(new Rule(data -> data.getAge() <= 2, () -> "Baby"));
        rules.add(new Rule(data -> 3 <= data.getAge() && data.getAge() <= 5, () -> "Toddler"));
        rules.add(new Rule(data -> data.getAge() >= 6, () -> "Human"));
    }

    public String resultFor(Data data) {

        return rules.stream()
                .filter(rule -> rule.testPredicate.test(data))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .result.get();
    }
}
