package hexlet.code.games;


public class Progression {
    static final int maxLengthOfProgression = 5;
    static final int maxRandomNumber = 30;

    public static String instructionInProgressionGame() {
        return "What number is missing in the progression?";
    }

    private static int[] generateProgression() {
        int length = Math.abs(maxLengthOfProgression + (int) (Math.random() * maxLengthOfProgression));
        int[] progression = new int[length];
        progression[0] = Math.abs((int) (Math.random() * (maxRandomNumber + 1)));
        var index = Math.abs((int) (Math.random() * (maxRandomNumber + 1)));

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

    public static int rightAnswerInProgressionGame(String question) {
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

        return rightAnswer;
   }
}
