package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    static final int MAX_OPERATION_COUNT = 3;
    static final int MAX_RANDOM_NUMBER = 30;

    private static String getOperation() {
        String[] operators = {"+", "-", "*"};
        var i = (int) (Math.random() * MAX_OPERATION_COUNT);
        return operators[i];
    }

    public static String instructionInCalcGame() {
        return "What is the result of the expression?";
    }

    public static String questionInCalcGame() {
        var num1 = (int) (Math.random() * (MAX_RANDOM_NUMBER + 1));
        var num2 = (int) (Math.random() * (MAX_RANDOM_NUMBER + 1));
        var operation = getOperation();
        return num1 + " " + operation + " " + num2;

    }

    public static int rightAnswerInCalcGame(String question) {
        Scanner scan = new Scanner(question);
        scan.useDelimiter(" ");
        int x = Integer.parseInt(scan.next());
        String operator = scan.next();
        int y = Integer.parseInt(scan.next());

        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            default -> 0;
        };
    }
}

