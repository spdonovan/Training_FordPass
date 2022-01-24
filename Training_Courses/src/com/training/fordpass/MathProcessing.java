package com.training.fordpass;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword();
    double doCalculation(double leftVal, double rightVal);
    default String getFormattedOutput() {
    return null;
}
}
