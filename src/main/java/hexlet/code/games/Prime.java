package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String INSTRUCTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_RANDOM_NUMBER = 100;

    private static boolean isNumberPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void runPrime() {
        String[][] primeQA = new String[Engine.ROUND_COUNT][2];
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            int question = Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1;
            primeQA[i][0] = Integer.toString(question);
            if (isNumberPrime(question)) {
                primeQA[i][1] = "yes";
            } else {
                primeQA[i][1] = "no";
            }
        }
        Engine.runGame(INSTRUCTION, primeQA);

    }
}
