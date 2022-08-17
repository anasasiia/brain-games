package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    static final int MAX_OPERATION_COUNT = 3;
    public static final String INSTRUCTION = "What is the result of the expression?";
    public static String[] questions = questionsInCalcGame();
    public static String[] answers = answersInCalcGame(questions);

    private static String getOperation() {
        String[] operators = {"+", "-", "*"};
        var i = (int) (Math.random() * MAX_OPERATION_COUNT);
        return operators[i];
    }

    public static String generateQuestionInCalcGame() {
        var num1 = (int) (Math.random() * (Engine.getMaxRandomNumber() + 1));
        var num2 = (int) (Math.random() * (Engine.getMaxRandomNumber() + 1));
        var operation = getOperation();
        return num1 + " " + operation + " " + num2;
    }

    public static String[] questionsInCalcGame() {
        String[] questions = new String[Engine.ROUND_COUNT];
        for (var i = 0; i < questions.length; i++) {
            questions[i] = generateQuestionInCalcGame();
        }
        return questions;
    }

    public static String[] answersInCalcGame(String[] questions) {
        String[] answers = new String[Engine.ROUND_COUNT];
        int index = 0;
        for (var question : questions) {
            Scanner scan = new Scanner(question);
            scan.useDelimiter(" ");
            int x = Integer.parseInt(scan.next());
            String operator = scan.next();
            int y = Integer.parseInt(scan.next());

            if (operator.equals("+")) {
                answers[index] = String.valueOf(x + y);
            } else if (operator.equals("-")) {
                answers[index] = String.valueOf(x - y);
            } else {
                answers[index] = String.valueOf(x * y);
            }
            index++;
        }
        return answers;
    }
}

