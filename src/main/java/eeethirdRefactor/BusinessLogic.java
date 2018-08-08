package eeethirdRefactor;

import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlow;
import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlowBuilder;
import model.Data;

import java.util.function.BiPredicate;
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

    private static BiPredicate<Data, Boundary> isAgeInRange = (data, boundary) -> {
        System.out.println("Testing boundry " + boundary);
        return data.getAge() >= boundary.lowerBounds && data.getAge() <= boundary.upperBounds;
    };

    private static Predicate<Data> isBaby = data -> isAgeInRange.test(data, new Boundary(0, 2));
    private static Predicate<Data> isToddler = data -> isAgeInRange.test(data, new Boundary(3, 5));
    private static Predicate<Data> isHuman = data -> isAgeInRange.test(data, new Boundary(6, Integer.MAX_VALUE));

}

class Boundary {
    public final Integer lowerBounds;
    public final Integer upperBounds;

    public Boundary(final Integer lowerBounds, Integer upperBounds) {
        this.lowerBounds = lowerBounds;
        this.upperBounds = upperBounds;
    }

    @Override
    public String toString() {
        return "Boundary{" +
                "lowerBounds=" + lowerBounds +
                ", upperBounds=" + upperBounds +
                '}';
    }

}
