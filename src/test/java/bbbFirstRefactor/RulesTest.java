package bbbFirstRefactor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RulesTest {

    final private RulesEngine rulesEngine = new RulesEngine();

    @Test
    public void babyIsTwoOrYounger() {
        Data data = new Data("Baby Boy", 2);
        Rule rule = rulesEngine.ruleFor(data);
        assertThat(rule).isInstanceOf(BabyRule.class);
        assertThat(rule.apply(data)).isEqualTo("Baby");
    }

    @Test
    public void newbornIsABaby() {
        Data data = new Data("Newborn", 0);
        Rule rule = rulesEngine.ruleFor(data);
        assertThat(rule).isInstanceOf(BabyRule.class);
        assertThat(rule.apply(data)).isEqualTo("Baby");
    }

    @Test
    public void toddlerIsThreeToFiveUpperBoundTest() {
        Data data = new Data("Youngster", 5);
        Rule rule = rulesEngine.ruleFor(data);
        assertThat(rule).isInstanceOf(ToddlerRule.class);
        assertThat(rule.apply(data)).isEqualTo("Toddler");
    }

    @Test
    public void toddlerIsThreeToFiveLowerBoundTest() {
        Data data = new Data("Youngster", 3);
        Rule rule = rulesEngine.ruleFor(data);
        assertThat(rule).isInstanceOf(ToddlerRule.class);
        assertThat(rule.apply(data)).isEqualTo("Toddler");
    }


    @Test
    public void olderThanFiveIsHumanLowerBound() {
        Data data = new Data("Kid", 6);
        Rule rule = rulesEngine.ruleFor(data);
        assertThat(rule).isInstanceOf(HumanRule.class);
        assertThat(rule.apply(data)).isEqualTo("Human");
    }

    @Test
    public void olderPeopleAreHumanToo() {
        Data data = new Data("Kodger", 99);
        Rule rule = rulesEngine.ruleFor(data);
        assertThat(rule).isInstanceOf(HumanRule.class);
        assertThat(rule.apply(data)).isEqualTo("Human");
    }

}
