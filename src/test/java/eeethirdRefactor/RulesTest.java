package eeethirdRefactor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RulesTest {

    final private DataProcessor dataProcessor = new DataProcessor();

    @Test
    public void babyIsTwoOrYounger() {
        Data data = new Data("Baby Boy", 2);
        assertThat(dataProcessor.resultFor(data)).isEqualTo("Baby");
    }

    @Test
    public void newbornIsABaby() {
        Data data = new Data("Newborn", 0);
        assertThat(dataProcessor.resultFor(data)).isEqualTo("Baby");
    }

    @Test
    public void toddlerIsThreeToFiveUpperBoundTest() {
        Data data = new Data("Youngster", 5);
        assertThat(dataProcessor.resultFor(data)).isEqualTo("Toddler");
    }

    @Test
    public void toddlerIsThreeToFiveLowerBoundTest() {
        Data data = new Data("Youngster", 3);
        assertThat(dataProcessor.resultFor(data)).isEqualTo("Toddler");
    }


    @Test
    public void olderThanFiveIsHumanLowerBound() {
        Data data = new Data("Kid", 6);
        assertThat(dataProcessor.resultFor(data)).isEqualTo("Human");
    }

    @Test
    public void olderPeopleAreHumanToo() {
        Data data = new Data("Kodger", 99);
        assertThat(dataProcessor.resultFor(data)).isEqualTo("Human");

    }

}
