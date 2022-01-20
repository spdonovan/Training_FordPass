package com.training.fordpass;

import java.time.LocalDate;
import java.util.Scanner;

public class CalcEngine {

    public static void main(String[] args) {
        performCalculations();
    }

    public static void performCalculations() {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }
    }




//        if (args.length == 0) {
//            for (int i = 0; i < opCodes.length; i++) {
//                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
//            }
//
//            for (double currentResult : results)
//                System.out.println(currentResult);
//        }   else if(args.length == 1 && args[0].equals("interactive"))
//            executeInteractively();
//        else if(args.length == 3)
//            handleCommandLine(args);
//        else
//            System.out.println("Please provide an operation code and 2 numeric values");
//            Scanner scanner = new Scanner(System.in);
//            String userInput = scanner.nextLine();
//            String[] parts = userInput.split(" ");
//            performOperation(parts);
//    }



//    private static void performOperation(String[] parts) {
//        char opCode = opCodeFromString(parts[0]);
//        if (opCode == 'w')
//            handleWhen(parts);
//        else {
//            double leftVal = valueFromWord(parts[1]);
//            double rightVal = valueFromWord(parts[2]);
//            double result = execute(opCode, leftVal, rightVal);
//            displayResult(opCode, leftVal, rightVal, result);
//        }
// }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
        System.out.println(output);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        String output = String.format("%.3f %c %.3f = %.3f", leftVal, symbol, rightVal, result);
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for (int index = 0; index < opCodes.length; index++) {
            if(opCode == opCodes[index]) {
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and 2 numbers:");
    }

//    private static void handleCommandLine(String[] args) {
//        char opCode = args[0].charAt(0);
//        double leftVal = Double.parseDouble(args[1]);
//        double rightVal = Double.parseDouble(args[2]);
//        double result = execute(opCode, leftVal, rightVal);
//        System.out.println(result);
//    }


    static char opCodeFromString(String operartionName) {
        char opCode = operartionName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };
        double value = -1d;
        for(int index = 0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        if(value == -1d)
           value =  Double.parseDouble(word);
        return value;
    }
}
