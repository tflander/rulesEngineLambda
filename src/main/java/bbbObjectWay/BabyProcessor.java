package bbbObjectWay;

import model.Data;

public class BabyProcessor implements Processor {
    @Override
    public String execute(Data data) {
        System.out.println("Processing data using BabyProcessor...");
        return "Baby";
    }
}
