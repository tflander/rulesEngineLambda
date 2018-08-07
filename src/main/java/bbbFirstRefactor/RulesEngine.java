package bbbFirstRefactor;

import java.util.ArrayList;
import java.util.List;

public class RulesEngine {

    final private static List<Rule> rules = new ArrayList<>();

    static {
        rules.add(new BabyRule());
        rules.add(new ToddlerRule());
        rules.add(new HumanRule());
    }

    public Rule ruleFor(Data data) {

        return rules.stream()
                .filter(rule -> rule.testPredicate().test(data))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
