package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String INSTRUCTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_RANDOM_NUMBER = 100;

    private static boolean isNumberPrime(String number) {
        if (Integer.parseInt(number) < 2) {
            return false;
        } else {
            for (int i = 2; i < Integer.parseInt(number); i++) {
                if (Integer.parseInt(number) % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void runPrime() {
        String[][] primeQA = new String[Engine.ROUND_COUNT][2];
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            primeQA[i][0] = Integer.toString(Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1);
            if (isNumberPrime(primeQA[i][0])) {
                primeQA[i][1] = "yes";
            } else {
                primeQA[i][1] = "no";
            }
        }
        Engine.runGame(INSTRUCTION, primeQA);

    }
}
