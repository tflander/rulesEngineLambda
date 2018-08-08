package bbbObjectWay;

import model.Data;

public class HumanProcessor implements Processor {
    @Override
    public String execute(Data data) {
        System.out.println("Processing data using HumanProcessor...");
        return "Human";
    }
}
