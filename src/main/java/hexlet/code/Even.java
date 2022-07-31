package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void gameEven() {
        System.out.println("Welcome to the Brain Games!");
        Scanner sc = new Scanner(System.in);
        System.out.print("May I have your name? ");
        var name = sc.nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        var rightAnswersTotalCount = 0;

        do {
            var number = (int) (Math.random() * (100 + 1));
            System.out.println("Question: " + number);
            Scanner answerInEvenGame = new Scanner(System.in);
            System.out.print("Your answer: ");
            String answer = answerInEvenGame.nextLine();

            if (number % 2 == 0) {
                if (answer.equals("yes")) {
                    System.out.println("Correct!");
                    rightAnswersTotalCount += 1;
                } else {
                    System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'yes'.\n"
                            + "Let's try again, " + name + "!");
                }
            } else {
                if (answer.equals("no")) {
                    System.out.println("Correct!");
                    rightAnswersTotalCount += 1;
                } else {
                    System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was 'no'.\n"
                            + "Let's try again, " + name + "!");
                }
            }

        } while (rightAnswersTotalCount <= 2);

        System.out.println("Congratulations, " + name + "!");
    }
}
