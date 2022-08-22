package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int MAX_LENGTH_PROGRESSION = 5;
    private static final int MAX_RANDOM_NUMBER = 50;
    private static final String INSTRUCTION = "What number is missing in the progression?";

    private static int[] generateProgression(int length, int firstElement, int index) {
        int[] progression = new int[length];
        progression[0] = firstElement;
        for (var i = 1; i < progression.length; i++) {
            progression[i] = progression[0] + (index * i);
        }
        return progression;
    }

    private static String hideNumber(int[] progression, int hiddenNumber) {
        var result = new StringBuilder();
        for (var i = 0; i < progression.length; i++) {
            if (i == hiddenNumber) {
                result.append("..");
            } else {
                result.append(progression[i]);
            }
            result.append(" ");
        }
        return result.toString();
    }

    public static void runProgression() {
        String[][] progressionQA = new String[Engine.ROUND_COUNT][2];
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            int length = Math.abs(MAX_LENGTH_PROGRESSION + Utils.generateRandomNumber(MAX_LENGTH_PROGRESSION));
            int firstElement = Math.abs(Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1);
            int index = Math.abs(Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1);
            int[] progression = generateProgression(length, firstElement, index);
            int hiddenNumber = Math.abs(Utils.generateRandomNumber(progression.length));
            progressionQA[i][0] = hideNumber(progression, hiddenNumber);
            progressionQA[i][1] = String.valueOf(progression[hiddenNumber]);
        }
        Engine.runGame(INSTRUCTION, progressionQA);
    }
}
