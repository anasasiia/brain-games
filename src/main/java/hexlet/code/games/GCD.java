package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String INSTRUCTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_RANDOM_NUMBER = 100;

    private static int getGCD(int number1, int number2) {
        int gcd = 0;

        for (var i = number2; i > 0; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static void runGCD() {
        String[][] gcdQA = new String[Engine.ROUND_COUNT][2];
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            int num1 = Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1;
            int num2 = Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1;
            gcdQA[i][0] = Math.abs(num1) + " " + Math.abs(num2);
            gcdQA[i][1] = Integer.toString(getGCD(num1, num2));
        }
        Engine.runGame(INSTRUCTION, gcdQA);
    }
}
