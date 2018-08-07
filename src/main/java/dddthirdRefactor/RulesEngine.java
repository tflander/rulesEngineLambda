package dddthirdRefactor;

import java.util.ArrayList;
import java.util.List;

public class RulesEngine {

    final private static List<Rule> rules = new ArrayList<>();

    static {
        rules.add(RuleBuilder.create().withAgeBetween(0).and(2).called("Baby"));
        rules.add(RuleBuilder.create().withAgeBetween(3).and(5).called("Toddler"));
        rules.add(RuleBuilder.create().withAgeBetween(6).and(Integer.MAX_VALUE).called("Human"));
    }

    public String resultFor(Data data) {

        return rules.stream()
                .filter(rule -> rule.testPredicate.test(data))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .result.get();
    }
}
