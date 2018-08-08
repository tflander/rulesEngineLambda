package eeethirdRefactor;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private final List<Rule> rules;

    public DataProcessor(List<Rule> rules) {
        this.rules = rules;
    }

    public String executeAndReturnResult(Data data) {

        Rule ruleForData = rules.stream()
                .filter(rule -> rule.testPredicate.test(data))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching rule for data: " + data));

        return ruleForData.execute.apply(data);
    }
}
