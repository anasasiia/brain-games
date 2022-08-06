package hexlet.code.games;


public class Progression {

    public static String instructionInProgressionGame() {
        return "What number is missing in the progression?";
    }

    private static int[] generateProgression() {
        int length = Math.abs(5 + (int) (Math.random() * 5));
        int[] progression = new int[length];
        progression[0] = Math.abs((int) (Math.random() * (30 + 1)));
        var index = Math.abs((int) (Math.random() * (30 + 1)));

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
