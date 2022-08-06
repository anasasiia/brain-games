package hexlet.code.games;

public class Even {
    public static String instructionInEvenGame() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    public static String questionInEvenGame() {
        var number = (int) (Math.random() * (100 + 1));
        return Integer.toString(number);
    }

    public static String rightAnswerInEvenGame(String number) {
        String answer;

        if (Integer.parseInt(number) % 2 == 0) {
            answer = "yes";
        } else {
            answer = "no";
        }
        return answer;
    }


}








