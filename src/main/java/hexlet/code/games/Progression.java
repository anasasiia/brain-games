package hexlet.code.games;


import hexlet.code.Engine;

public class Progression {
    static final int MAX_LENGTH_PROGRESSION = 5;
    static final int MAX_RANDOM_NUMBER = 30;

    private static String instruction = "What number is missing in the progression?";

    private static int[] generateProgression() {
        int length = Math.abs(MAX_LENGTH_PROGRESSION + (int) (Math.random() * MAX_LENGTH_PROGRESSION));
        int[] progression = new int[length];
        progression[0] = Math.abs((int) (Math.random() * (MAX_RANDOM_NUMBER + 1)));
        var index = Math.abs((int) (Math.random() * (MAX_RANDOM_NUMBER + 1)));

        for (var i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + index;
        }
        return progression;
    }

    public static String questionInProgressionGame() {
        int[] progression = generateProgression();
        int hiddenNumber = Math.abs((int) (Math.random() * progression.length));

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

    private static int getHiddenNumber(String[] progression) {
        var indexHiddenNumber = 0;
        while (indexHiddenNumber < progression.length && !progression[indexHiddenNumber].equals("..")) {
            indexHiddenNumber++;
        }
        return indexHiddenNumber;
    }

    public static String rightAnswerInProgressionGame(String question) {
        String[] progression = question.split(" ");
        var length = progression.length;
        var index = 0;

        if (!progression[0].equals("..") && !progression[1].equals("..")) {
            var i = Integer.valueOf(progression[0]);
            var j = Integer.valueOf(progression[1]);
            index = j - i;
        } else {
            var k = Integer.valueOf(progression[length - 1]);
            var l = Integer.valueOf(progression[length - 2]);
            index = k - l;
        }
        var hiddenNumber = getHiddenNumber(progression);
        var rightAnswer = 0;
        if (progression[0].equals("..")) {
            rightAnswer = (Integer.parseInt(progression[length - 1])) - (index * (length - 1 - hiddenNumber));
        } else {
            rightAnswer = Integer.parseInt(progression[0]) + index * hiddenNumber;
        }

        return String.valueOf(rightAnswer);
    }

    public static void playProgressionGame() {
        Engine.getName();
        Engine.getInstruction(instruction);

        var rightAnswersCount = 0;
        do {
            String question = questionInProgressionGame();
            Engine.getQuestion(question);
            String answer = Engine.getAnswerFromUser();
            String rightAnswer = rightAnswerInProgressionGame(question);

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
