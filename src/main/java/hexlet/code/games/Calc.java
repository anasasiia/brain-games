package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    static final int MAX_OPERATION_COUNT = 3;
    static final int MAX_RANDOM_NUMBER = 30;
    private static String instruction = "What is the result of the expression?";

    private static String getOperation() {
        String[] operators = {"+", "-", "*"};
        var i = (int) (Math.random() * MAX_OPERATION_COUNT);
        return operators[i];
    }

    public static String questionInCalcGame() {
        var num1 = (int) (Math.random() * (MAX_RANDOM_NUMBER + 1));
        var num2 = (int) (Math.random() * (MAX_RANDOM_NUMBER + 1));
        var operation = getOperation();
        return num1 + " " + operation + " " + num2;

    }

    public static String rightAnswerInCalcGame(String question) {
        Scanner scan = new Scanner(question);
        scan.useDelimiter(" ");
        int x = Integer.parseInt(scan.next());
        String operator = scan.next();
        int y = Integer.parseInt(scan.next());
        int result;

        if (operator.equals("+")) {
            result = x + y;
        } else if (operator.equals("-")) {
            result = x - y;
        } else {
            result = x * y;
        }
        return String.valueOf(result);
    }

    public static void playCalcGame() {
        Engine.getName();
        Engine.getInstruction(instruction);

        var rightAnswersCount = 0;
        do {
            String question = questionInCalcGame();
            Engine.getQuestion(question);
            String answer = Engine.getAnswerFromUser();
            String rightAnswer = rightAnswerInCalcGame(question);

            boolean result = Engine.compareAnswers(answer, rightAnswer);

            if (result) {
                Engine.getCorrect();
                rightAnswersCount++;
            } else {
                Engine.getWrongAnswer(answer, rightAnswer);
            }

        } while (rightAnswersCount < Engine.getRoundCount());

        Engine.getCongratulations();
    }
}

