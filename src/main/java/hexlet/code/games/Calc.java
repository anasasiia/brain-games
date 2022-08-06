package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    private static String getOperation() {
        String[] operators = {"+", "-", "*"};
        var i = (int) (Math.random() * 3);
        return operators[i];
    }

    public static String instructionInCalcGame() {
        return "What is the result of the expression?";
    }

    public static String questionInCalcGame() {
        var num1 = (int) (Math.random() * (30 + 1));
        var num2 = (int) (Math.random() * (30 + 1));
        var operation = getOperation();
        return num1 + " " + operation + " " + num2;

    }

    public static int rightAnswerInCalcGame (String question) {
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

