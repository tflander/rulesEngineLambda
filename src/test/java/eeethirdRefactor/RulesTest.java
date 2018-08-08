package eeethirdRefactor;

import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlow;
import model.Data;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RulesTest {

    final private FirstMatchingRuleDataFlow firstMatchingRuleDataFlow = new FirstMatchingRuleDataFlow(new BusinessLogic().getRules());

    @Test
    public void babyIsTwoOrYounger() {
        Data data = new Data("Baby Boy", 2);
        assertThat(firstMatchingRuleDataFlow.executeAndReturnResult(data)).isEqualTo("Baby");
    }

    @Test
    public void newbornIsABaby() {
        Data data = new Data("Newborn", 0);
        assertThat(firstMatchingRuleDataFlow.executeAndReturnResult(data)).isEqualTo("Baby");
    }

    @Test
    public void toddlerIsThreeToFiveUpperBoundTest() {
        Data data = new Data("Youngster", 5);
        assertThat(firstMatchingRuleDataFlow.executeAndReturnResult(data)).isEqualTo("Toddler");
    }

    @Test
    public void toddlerIsThreeToFiveLowerBoundTest() {
        Data data = new Data("Youngster", 3);
        assertThat(firstMatchingRuleDataFlow.executeAndReturnResult(data)).isEqualTo("Toddler");
    }


    @Test
    public void olderThanFiveIsHumanLowerBound() {
        Data data = new Data("Kid", 6);
        assertThat(firstMatchingRuleDataFlow.executeAndReturnResult(data)).isEqualTo("Human");
    }

    @Test
    public void olderPeopleAreHumanToo() {
        Data data = new Data("Kodger", 99);
        assertThat(firstMatchingRuleDataFlow.executeAndReturnResult(data)).isEqualTo("Human");

    }

}
