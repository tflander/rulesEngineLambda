package cccFirstRefactor;

import model.Data;

import java.util.ArrayList;
import java.util.List;

public class ProcessorFactory {

    final private static List<Processor> PROCESSORS = new ArrayList<>();

    static {
        PROCESSORS.add(new BabyProcessor());
        PROCESSORS.add(new ToddlerProcessor());
        PROCESSORS.add(new HumanProcessor());
    }

    public Processor ruleFor(Data data) {

        return PROCESSORS.stream()
                .filter(rule -> rule.testPredicate().test(data))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
