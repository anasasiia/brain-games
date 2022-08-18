package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GCD {
    private static final String INSTRUCTION = "Find the greatest common divisor of given numbers.";
    private static final String[] QUESTIONS = questionsInGcdGame();
    private static final String[] ANSWERS = answersInGcdGame(QUESTIONS);

    public static String[] getAnswers() {
        return ANSWERS;
    }

    public static String[] getQuestions() {
        return QUESTIONS;
    }

    public static String getInstruction() {
        return INSTRUCTION;
    }


    public static String generateQuestionInGcdGame() {
        var num1 = (int) (Math.random() * (Engine.getMaxRandomNumber()) + 1);
        var num2 = (int) (Math.random() * (Engine.getMaxRandomNumber()) + 1);
        return Math.abs(num1) + " " + Math.abs(num2);
    }

    public static String[] questionsInGcdGame() {
        String[] questions = new String[Engine.ROUND_COUNT];
        for (var i = 0; i < questions.length; i++) {
            questions[i] = generateQuestionInGcdGame();
        }
        return questions;
    }

    public static String[] answersInGcdGame(String[] questions) {
        String[] answers = new String[Engine.ROUND_COUNT];
        int index = 0;
        for (var question : questions) {
            Scanner scan = new Scanner(question);
            scan.useDelimiter(" ");
            int x = Integer.parseInt(scan.next());
            int y = Integer.parseInt(scan.next());
            int gcd = 0;

            for (var i = y; i > 0; i--) {
                if (x % i == 0 && y % i == 0) {
                    gcd = i;
                    break;
                }
            }
            answers[index] = String.valueOf(gcd);
            index++;
        }
        return answers;
    }
}
