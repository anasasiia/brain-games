package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int MAX_LENGTH_PROGRESSION = 5;
    private static final int MAX_RANDOM_NUMBER = 50;
    private static final String INSTRUCTION = "What number is missing in the progression?";

    private static String generateProgression(int length, int firstElement, int index) {
        int[] progression = new int[length];
        progression[0] = firstElement;
        for (var i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + index;
        }

        int hiddenNumber = Math.abs(Utils.generateRandomNumber(progression.length));

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

    private static int getHiddenNumber(String progression) {
        String[] question = progression.split(" ");
        var indexHiddenNumber = 0;
        while (indexHiddenNumber < question.length && !question[indexHiddenNumber].equals("..")) {
            indexHiddenNumber++;
        }
        return indexHiddenNumber;
    }

    public static void runProgression() {
        String[][] progressionQA = new String[Engine.ROUND_COUNT][2];
        for (var i = 0; i < Engine.ROUND_COUNT; i++) {
            int length = Math.abs(MAX_LENGTH_PROGRESSION + Utils.generateRandomNumber(MAX_LENGTH_PROGRESSION));
            int firstElement = Math.abs(Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1);
            int index = Math.abs(Utils.generateRandomNumber(MAX_RANDOM_NUMBER) + 1);
            progressionQA[i][0] = generateProgression(length, firstElement, index);
            progressionQA[i][1] = String.valueOf(firstElement + (index * getHiddenNumber(progressionQA[i][0])));
        }
        Engine.runGame(INSTRUCTION, progressionQA);
    }
}
