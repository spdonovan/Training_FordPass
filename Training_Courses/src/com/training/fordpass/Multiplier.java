package com.training.fordpass;

public class Multiplier extends CalculateBase {
    @Override
    public void calculate() {
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }
}
