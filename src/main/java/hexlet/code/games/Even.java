package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String INSTRUCTION = "Answer 'yes' if number even otherwise answer 'no'.";
    private static final int MAX_RANDOM_NUMBER = 100;

    private static boolean isNumberEven(String number) {
        return Integer.parseInt(number) % 2 == 0;
    }

    public static void runEven() {
        String[][] evenQA = new String[Engine.ROUND_COUNT][2];
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            evenQA[i][0] = Integer.toString(Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1);
            if (isNumberEven(evenQA[i][0])) {
                evenQA[i][1] = "yes";
            } else {
                evenQA[i][1] = "no";
            }
        }
        Engine.runGame(INSTRUCTION, evenQA);
    }
}














