package eeethirdRefactor;

import eeethirdRefactor.executionFlow.FirstMatchingRuleDataFlow;
import model.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessLogicTest {

    private final String expectedResult = "expected";
    private final String unexpectedResult = "unexpected";

    @InjectMocks
    private BusinessLogic businessLogic;

    @Mock
    private ProcessorFunctions functions;

    @Before
    public void setUp() {
        when(functions.processDataForBaby(any(Data.class))).thenReturn(unexpectedResult);
        when(functions.processDataForToddler(any(Data.class))).thenReturn(unexpectedResult);
        when(functions.processDataForHuman(any(Data.class))).thenReturn(unexpectedResult);
    }

    @Test
    public void babiesAreMappedToTheCorrectProcessingFunction() {
        Data babyBoy = new Data("Baby Boy", 1);
        when(functions.processDataForBaby(babyBoy)).thenReturn(expectedResult);

        FirstMatchingRuleDataFlow<Data, String> flow = businessLogic.getFlow();
        assertThat(flow.executeAndReturnResult(babyBoy)).isEqualTo(expectedResult);
    }

    @Test
    public void toddlersAreMappedToTheCorrectProcessingFunction() {
        Data toddler = new Data("Mikey", 3);
        when(functions.processDataForToddler(toddler)).thenReturn(expectedResult);

        FirstMatchingRuleDataFlow<Data, String> flow = businessLogic.getFlow();
        assertThat(flow.executeAndReturnResult(toddler)).isEqualTo(expectedResult);
    }

    @Test
    public void humansAreMappedToTheCorrectProcessingFunction() {
        Data oldMan = new Data("Abe", 100);
        when(functions.processDataForHuman(oldMan)).thenReturn(expectedResult);

        FirstMatchingRuleDataFlow<Data, String> flow = businessLogic.getFlow();
        assertThat(flow.executeAndReturnResult(oldMan)).isEqualTo(expectedResult);
    }
}