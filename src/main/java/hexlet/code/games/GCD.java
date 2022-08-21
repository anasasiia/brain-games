package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

public class GCD {
    private static final String INSTRUCTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_RANDOM_NUMBER = 100;

    public static String generateQuestionInGcdGame() {
        int num1 = Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1;
        int num2 = Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1;
        return Math.abs(num1) + " " + Math.abs(num2);
    }

    private static String getGCD(String question) {
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
        scan.close();
        return String.valueOf(gcd);
    }

    public static void runGCD() {
        String[][] gcdQA = new String[Engine.ROUND_COUNT][2];
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            gcdQA[i][0] = generateQuestionInGcdGame();
            gcdQA[i][1] = getGCD(gcdQA[i][0]);
        }
        Engine.runGame(INSTRUCTION, gcdQA);
    }
}
