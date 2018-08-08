package eeethirdRefactor;

import model.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BusinessLogic {

    public List<ConditionalExecutor<Data, String>> getRules() {
        ArrayList<ConditionalExecutor<Data, String>> conditionalExecutors = new ArrayList<>();
        conditionalExecutors.add(new ConditionalExecutor<>(isBaby, ProcessorFunctions::processDataForBaby));
        conditionalExecutors.add(new ConditionalExecutor<>(isToddler, ProcessorFunctions::processDataForToddler));
        conditionalExecutors.add(new ConditionalExecutor<>(isHuman, ProcessorFunctions::processDataForHuman));
        return conditionalExecutors;
    }

    private static BiPredicate<Data, Boundary> isAgeInRange = (data, boundary) -> {
        System.out.println("Testing boundry " + boundary);
        return data.getAge() >= boundary.lowerBounds && data.getAge() <= boundary.upperBounds;
    };
    private static Predicate<Data> isBaby = data -> isAgeInRange.test(data, new Boundary(0,2));
    private static Predicate<Data> isToddler = data -> isAgeInRange.test(data, new Boundary(3,5));
    private static Predicate<Data> isHuman = data -> isAgeInRange.test(data, new Boundary(6,Integer.MAX_VALUE));

}
