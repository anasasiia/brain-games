package hexlet.code.games;

public class Prime {
    static final int maxRandomNumber = 100;
    static final int maxSimpleNumber = 9;
    public static String instructionInPrimeGame() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static String questionInPrimeGame() {
        var number = Math.abs((int) (Math.random() * (maxRandomNumber + 2)));
        return Integer.toString(number);
    }

    public static String rightAnswerInPrimeGame(String question) {
        var number = Integer.parseInt(question);
        int i = 2;

        do {
            var surplus = number % i;
            if (surplus == 0) {
                return "no";
            } else {
                i++;
            }
        } while (i <= maxSimpleNumber);
        return "yes";
    }
}
