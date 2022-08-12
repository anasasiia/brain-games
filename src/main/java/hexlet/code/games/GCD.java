package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GCD {
    private static final String INSTRUCTION = "Find the greatest common divisor of given numbers.";


    public static String questionInGcdGame() {
        var num1 = (int) (Math.random() * (Engine.getMaxRandomNumber()) + 1);
        var num2 = (int) (Math.random() * (Engine.getMaxRandomNumber()) + 1);
        return Math.abs(num1) + " " + Math.abs(num2);
    }

    public static String rightAnswerInGcdGame(String question) {
        Scanner scan = new Scanner(question);
        scan.useDelimiter(" ");
        int x = Integer.parseInt(scan.next());
        int y = Integer.parseInt(scan.next());

        var gcd = 0;

        for (var i = y; i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
                break;
            }
        }
        return String.valueOf(gcd);
    }

    public static void playGCDGame() {
        Engine.getName();
        Engine.getInstruction(INSTRUCTION);

        var rightAnswersCount = 0;
        do {
            String question = questionInGcdGame();
            Engine.getQuestion(question);
            String answer = Engine.getAnswerFromUser();
            String rightAnswer = rightAnswerInGcdGame(question);

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
