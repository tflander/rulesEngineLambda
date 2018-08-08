package eeethirdRefactor.executionFlow;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstMatchingRuleDataFlowTest {

    private final Fruit banana = new Fruit("Banana", true, false);
    private final Fruit tomato = new Fruit("Tomato", false, true);

    private final Predicate<Fruit> testForFruitSalad = fruit -> fruit.isGoodForFruitSalad;
    private final Predicate<Fruit> testForPizza = fruit -> fruit.isGoodForPizza;

    private final Function<Fruit, String> processFruitFor(String useForFruit) {
        return (fruit -> "purchased " + fruit.name.toLowerCase() + " for " + useForFruit);
    }

    private final FirstMatchingRuleDataFlow<Fruit, String> flow = FirstMatchingRuleDataFlowBuilder.create()
            .addingCondition(testForFruitSalad).toRun(processFruitFor("fruit salad"))
            .addingCondition(testForPizza).toRun(processFruitFor("pizza"))
            .build();

    @Test
    public void recommendsTomatoForPizza() {
        assertThat(flow.executeAndReturnResult(tomato)).isEqualTo("purchased tomato for pizza");
    }

    @Test
    public void recommendsBananaForFruitSalad() {
        assertThat(flow.executeAndReturnResult(banana)).isEqualTo("purchased banana for fruit salad");
    }

    class Fruit {
        final public String name;
        final public Boolean isGoodForFruitSalad;
        final public Boolean isGoodForPizza;

        Fruit(String name, Boolean isGoodForFruitSalad, Boolean isGoodForPizza) {
            this.name = name;
            this.isGoodForFruitSalad = isGoodForFruitSalad;
            this.isGoodForPizza = isGoodForPizza;
        }
    }
}