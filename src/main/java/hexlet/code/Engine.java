package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Even;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    public static void games() {
        final int choiceEven = 2;
        final int choiceCalc = 3;
        final int choiceGCD = 4;
        final int choiceProgression = 5;
        final int choicePrime = 6;

        Scanner choice = new Scanner(System.in);
        System.out.print("Your choice: ");
        var gameChosen = choice.nextInt();

        if (gameChosen == 1) {
            Cli.getName();
        } else {
            System.out.println("Welcome to the Brain Games!");
            Scanner nameScanner = new Scanner(System.in);
            System.out.print("May I have your name? ");
            var name = nameScanner.nextLine();
            System.out.println("Hello, " + name + "!");

            String instruction = null;
            if (gameChosen == choiceEven) {
                instruction = Even.instructionInEvenGame();
            } else if (gameChosen == choiceCalc) {
                instruction = Calc.instructionInCalcGame();
            } else if (gameChosen == choiceGCD) {
                instruction = GCD.instructionInGcdGame();
            } else if (gameChosen == choiceProgression) {
                instruction = Progression.instructionInProgressionGame();
            } else if (gameChosen == choicePrime) {
                instruction = Prime.instructionInPrimeGame();
            }
            System.out.println(instruction);

            var rightAnswersCount = 0;

            do {
                String question = null;
                if (gameChosen == choiceEven) {
                    question = Even.questionInEvenGame();
                } else if (gameChosen == choiceCalc) {
                    question = Calc.questionInCalcGame();
                } else if (gameChosen == choiceGCD) {
                    question = GCD.questionInGcdGame();
                } else if (gameChosen == choiceProgression) {
                    question = Progression.questionInProgressionGame();
                } else if (gameChosen == choicePrime) {
                    question = Prime.questionInPrimeGame();
                }

                System.out.println("Question: " + question);

                String answer = null;
                Scanner answerInGame = new Scanner(System.in);
                System.out.print("Your answer: ");
                if (gameChosen == choiceEven) {
                    answer = answerInGame.nextLine();
                } else if (gameChosen == choiceCalc) {
                    answer = Integer.toString(answerInGame.nextInt());
                } else if (gameChosen == choiceGCD) {
                    answer = Integer.toString(answerInGame.nextInt());
                } else if (gameChosen == choiceProgression) {
                    answer = Integer.toString(answerInGame.nextInt());
                } else if (gameChosen == choicePrime) {
                    answer = answerInGame.nextLine();
                }

                String rightAnswer = null;
                if (gameChosen == choiceEven) {
                    rightAnswer = Even.rightAnswerInEvenGame(question);
                } else if (gameChosen == choiceCalc) {
                    rightAnswer = String.valueOf(Calc.rightAnswerInCalcGame(question));
                } else if (gameChosen == choiceGCD) {
                    rightAnswer = String.valueOf(GCD.rightAnswerInGcdGame(question));
                } else if (gameChosen == choiceProgression) {
                    rightAnswer = String.valueOf(Progression.rightAnswerInProgressionGame(question));
                } else if (gameChosen == choicePrime) {
                    rightAnswer = Prime.rightAnswerInPrimeGame(question);
                }


                assert answer != null;
                if (answer.equals(rightAnswer)) {
                    System.out.println("Correct!");
                    rightAnswersCount += 1;
                } else {
                    System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was" + "'"
                            + rightAnswer + "'.\n" + "Let's try again, " + name + "!");
                }

            } while (rightAnswersCount <= 2);

            System.out.println("Congratulations, " + name + "!");
        }
    }
}


