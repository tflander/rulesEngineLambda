package eeethirdRefactor;

import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlow;
import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlowBuilder;
import model.Data;

import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public class BusinessLogic {

    private final ProcessorFunctions functions = new ProcessorFunctions();
    private final Predicate<Data> isBaby = isAgeInRange(0, 2);
    private final Predicate<Data> isToddler = isAgeInRange(3, 5);
    private final Predicate<Data> isHuman = isAgeInRange(6, Integer.MAX_VALUE);

    public FirstMatchingRuleDataFlow<Data, String> getFlow() {

        return FirstMatchingRuleDataFlowBuilder.create()
                .addingCondition(isBaby).toRun(data -> functions.processDataForBaby((Data)data))
                .addingCondition(isToddler).toRun(data -> functions.processDataForToddler((Data)data))
                .addingCondition(isHuman).toRun(data -> functions.processDataForHuman((Data)data))
                .build();

    }

    private Predicate<Data> isAgeInRange(int lower, int upper) {
        return (data -> lower <= data.getAge() && data.getAge() <= upper);
    }

}
