package eeethirdRefactor;

import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlow;
import model.Data;

import java.util.function.Predicate;

public class BusinessLogic {

    private ProcessorFunctions functions = new ProcessorFunctions();

    private final Predicate<Data> isBaby = isAgeInRange(0, 2);
    private final Predicate<Data> isToddler = isAgeInRange(3, 5);
    private final Predicate<Data> isHuman = isAgeInRange(6, Integer.MAX_VALUE);

    public FirstMatchingRuleDataFlow<Data, String> getFlow() {

        return FirstMatchingRuleDataFlow.Builder.<Data, String>create()
                .addingCondition(isBaby).toRun(functions::processDataForBaby)
                .addingCondition(isToddler).toRun(functions::processDataForToddler)
                .addingCondition(isHuman).toRun(functions::processDataForHuman)
                .build();
    }

    private Predicate<Data> isAgeInRange(int lower, int upper) {
        return (data -> lower <= data.getAge() && data.getAge() <= upper);
    }

}
