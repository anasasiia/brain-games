package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUND_COUNT = 3;
    static final int MAX_RANDOM_NUMBER = 50;

    public static int getMaxRandomNumber() {
        return MAX_RANDOM_NUMBER;
    }


    public static void runGame(String instruction, String[] questions, String[] answers) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner nameScanner = new Scanner(System.in);
        String playerName = nameScanner.nextLine();
        System.out.println("Hello, " + playerName + "!");

        System.out.println(instruction);
        int index1 = 0;
        int index2 = 0;
        for (var rightAnswersCount = 0; rightAnswersCount < ROUND_COUNT; rightAnswersCount++) {
            System.out.println("Question: " + questions[index1]);

            Scanner answerInGame = new Scanner(System.in);
            System.out.print("Your answer: ");
            String answerFromUser;
            if (answerInGame.hasNextInt()) {
                answerFromUser = String.valueOf(answerInGame.nextInt());
            } else {
                answerFromUser = answerInGame.nextLine();
            }

            if (answerFromUser.equals(answers[index2])) {
                System.out.println("Correct!");
                index1++;
                index2++;
            } else {
                System.out.println("'" + answerFromUser + "'" + " is wrong answer ;(. Correct answer was " + "'"
                        + answers[index2] + "'.\n" + "Let's try again, " + playerName + "!");
                System.exit(0);
            }
            System.out.println("Congratulations, " + playerName + "!");
        }

    }

}


