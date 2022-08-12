package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    static final int MAX_OPERATION_COUNT = 3;
    private static final String INSTRUCTION = "What is the result of the expression?";

    private static String getOperation() {
        String[] operators = {"+", "-", "*"};
        var i = (int) (Math.random() * MAX_OPERATION_COUNT);
        return operators[i];
    }

    public static String questionInCalcGame() {
        var num1 = (int) (Math.random() * (Engine.getMaxRandomNumber() + 1));
        var num2 = (int) (Math.random() * (Engine.getMaxRandomNumber() + 1));
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
        Engine.getInstruction(INSTRUCTION);

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

