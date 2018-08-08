package bbbObjectWay;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RulesTest {

    final private ProcessorFactory processorFactory = new ProcessorFactory();

    @Test
    public void babyIsTwoOrYounger() {
        Data data = new Data("Baby Boy", 2);
        Processor processor = processorFactory.processorFor(data);
        assertThat(processor).isInstanceOf(BabyProcessor.class);
        assertThat(processor.execute(data)).isEqualTo("Baby");
    }

    @Test
    public void newbornIsABaby() {
        Data data = new Data("Newborn", 0);
        Processor processor = processorFactory.processorFor(data);
        assertThat(processor).isInstanceOf(BabyProcessor.class);
        assertThat(processor.execute(data)).isEqualTo("Baby");
    }

    @Test
    public void toddlerIsThreeToFiveUpperBoundTest() {
        Data data = new Data("Youngster", 5);
        Processor processor = processorFactory.processorFor(data);
        assertThat(processor).isInstanceOf(ToddlerProcessor.class);
        assertThat(processor.execute(data)).isEqualTo("Toddler");
    }

    @Test
    public void toddlerIsThreeToFiveLowerBoundTest() {
        Data data = new Data("Youngster", 3);
        Processor processor = processorFactory.processorFor(data);
        assertThat(processor).isInstanceOf(ToddlerProcessor.class);
        assertThat(processor.execute(data)).isEqualTo("Toddler");
    }


    @Test
    public void olderThanFiveIsHumanLowerBound() {
        Data data = new Data("Kid", 6);
        Processor processor = processorFactory.processorFor(data);
        assertThat(processor).isInstanceOf(HumanProcessor.class);
        assertThat(processor.execute(data)).isEqualTo("Human");
    }

    @Test
    public void olderPeopleAreHumanToo() {
        Data data = new Data("Kodger", 99);
        Processor processor = processorFactory.processorFor(data);
        assertThat(processor).isInstanceOf(HumanProcessor.class);
        assertThat(processor.execute(data)).isEqualTo("Human");
    }

}
