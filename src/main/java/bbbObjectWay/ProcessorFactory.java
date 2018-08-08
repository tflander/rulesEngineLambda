package bbbObjectWay;

public class ProcessorFactory {
    public Processor processorFor(Data data) {

        if(data.getAge() <= 2) {
            return new BabyProcessor();
        } else if(data.getAge() <= 5) {
            return new ToddlerProcessor();
        }
        return new HumanProcessor();
    }
}
