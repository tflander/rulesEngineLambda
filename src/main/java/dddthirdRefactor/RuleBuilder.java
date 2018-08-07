package dddthirdRefactor;

public class RuleBuilder {
    private int lowerAgeBoundry;
    private int upperAgeBoundry;

    public static RuleBuilder create() {
        return new RuleBuilder();
    }

    public RuleBuilder withAgeBetween(int lowerAgeBoundry) {
        this.lowerAgeBoundry = lowerAgeBoundry;
        return this;
    }

    public RuleBuilder and(int upperAgeBoundry) {
        this.upperAgeBoundry = upperAgeBoundry;
        return this;
    }

    public Rule called(String result) {
        return new Rule(data -> lowerAgeBoundry <= data.getAge() && data.getAge() <= upperAgeBoundry, () -> result);
    }
}
