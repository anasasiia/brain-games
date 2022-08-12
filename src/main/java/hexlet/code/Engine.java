package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String playerName;
    static final int ROUND_COUNT = 3;
    static final int MAX_RANDOM_NUMBER = 50;

    public static int getRoundCount() {
        return ROUND_COUNT;
    }

    public static int getMaxRandomNumber() {
        return MAX_RANDOM_NUMBER;
    }

    public static String getName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner nameScanner = new Scanner(System.in);
        playerName = nameScanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }

    public static void getInstruction(String instruction) {
        System.out.println(instruction);
    }

    public static void getQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static String getAnswerFromUser() {
        Scanner answerInGame = new Scanner(System.in);
        System.out.print("Your answer: ");
        String answerFromUser;
        if (answerInGame.hasNextInt()) {
            answerFromUser = String.valueOf(answerInGame.nextInt());
        } else {
            answerFromUser = answerInGame.nextLine();
        }
        return answerFromUser;
    }

    public static boolean compareAnswers(String answerFromUser, String rightAnswer) {
        return answerFromUser.equals(rightAnswer);
    }

    public static void getCorrect() {
        System.out.println("Correct!");
    }

    public static void getWrongAnswer(String answerFromUser, String rightAnswer) {
        System.out.println("'" + answerFromUser + "'" + " is wrong answer ;(. Correct answer was " + "'"
                + rightAnswer + "'.\n" + "Let's try again, " + playerName + "!");
        System.exit(0);
    }

    public static void getCongratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

}


