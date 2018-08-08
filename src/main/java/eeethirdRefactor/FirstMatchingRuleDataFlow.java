package eeethirdRefactor;

import model.Data;

import java.util.List;

public class FirstMatchingRuleDataFlow<T> {

    private final List<Rule<T>> rules;

    public FirstMatchingRuleDataFlow(List<Rule<T>> rules) {
        this.rules = rules;
    }

    public T executeAndReturnResult(Data data) {

        Rule<T> ruleForData = rules.stream()
                .filter(rule -> rule.testPredicate.test(data))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching rule for data: " + data));

        return ruleForData.execute.apply(data);
    }
}
