package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUND_COUNT = 3;

    public static void runGame(String instruction, String[][] gameQA) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner userScanner = new Scanner(System.in);
        String playerName = userScanner.nextLine();
        System.out.println("Hello, " + playerName + "!");

        System.out.println(instruction);
        int index = 0;
        for (var rightAnswersCount = 0; rightAnswersCount < ROUND_COUNT; rightAnswersCount++) {
            System.out.println("Question: " + gameQA[index][0]);

            System.out.print("Your answer: ");
            String answerFromUser = userScanner.nextLine();

            if (answerFromUser.equals(gameQA[index][1])) {
                System.out.println("Correct!");
                index++;
            } else {
                System.out.println("'" + answerFromUser + "'" + " is wrong answer ;(. Correct answer was " + "'"
                        + gameQA[index][1] + "'.\n" + "Let's try again, " + playerName + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}


