package bbbObjectWay;

public class RulesEngine {
    public Rule ruleFor(Data data) {

        if(data.getAge() <= 2) {
            return new BabyRule();
        } else if(data.getAge() <= 5) {
            return new ToddlerRule();
        }
        return new HumanRule();
    }
}
