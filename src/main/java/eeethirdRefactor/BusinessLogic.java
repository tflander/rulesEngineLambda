package eeethirdRefactor;

import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlow;
import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlowBuilder;
import model.Data;

import java.util.function.Predicate;

public class BusinessLogic {

    ProcessorFunctions functions = new ProcessorFunctions();

    public FirstMatchingRuleDataFlow<Data, String> getFlow() {

        return FirstMatchingRuleDataFlowBuilder.create()
                .addingCondition(isBaby).toRun(functions.processDataForBaby)
                .addingCondition(isToddler).toRun(functions.processDataForToddler)
                .addingCondition(isHuman).toRun(functions.processDataForHuman)
                .build();
    }

    private static Predicate<Data> isAgeInRange(int lower, int upper) {
        return (data -> lower <= data.getAge() && data.getAge() <= upper);
    }

    private static Predicate<Data> isBaby = isAgeInRange(0, 2);
    private static Predicate<Data> isToddler = isAgeInRange(3, 5);
    private static Predicate<Data> isHuman = isAgeInRange(6, Integer.MAX_VALUE);
}
