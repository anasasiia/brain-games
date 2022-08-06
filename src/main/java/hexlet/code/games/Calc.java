package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    static final int maxOperationCount = 3;
    static final int maxRandomNumber = 30;

    private static String getOperation() {
        String[] operators = {"+", "-", "*"};
        var i = (int) (Math.random() * maxOperationCount);
        return operators[i];
    }

    public static String instructionInCalcGame() {
        return "What is the result of the expression?";
    }

    public static String questionInCalcGame() {
        var num1 = (int) (Math.random() * (maxRandomNumber + 1));
        var num2 = (int) (Math.random() * (maxRandomNumber + 1));
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

