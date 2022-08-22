package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    static final int MAX_OPERATOR_COUNT = 3;
    private static final int MAX_RANDOM_NUMBER = 50;
    private static final String INSTRUCTION = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    private static String getOperator() {
        int i = Utils.generateRandomNumber(MAX_OPERATOR_COUNT);
        return Calc.OPERATORS[i];
    }

    private static int calculate(int number1, int number2, String operator) {
        int result = 0;
        switch (operator) {
            case "+" -> {
                result = number1 + number2;
            }
            case "-" -> {
                result = number1 - number2;
            }
            case "*" -> {
                result = number1 * number2;
            }
            default -> System.out.println("Unexpected value");
        }
        return result;
    }

    public static void runCalc() {
        String[][] calcQA = new String[Engine.ROUND_COUNT][2];
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            int num1 = Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1;
            int num2 = Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1;
            String operator = getOperator();
            calcQA[i][0] = num1 + " " + operator + " " + num2;
            calcQA[i][1] = Integer.toString(calculate(num1, num2, operator));
        }
        Engine.runGame(INSTRUCTION, calcQA);
    }

}



