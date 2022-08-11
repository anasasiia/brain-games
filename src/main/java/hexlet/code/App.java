package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

import static java.lang.System.out;


public class App {
    static final int choiceEven = 2;
    static final int choiceCalc = 3;
    static final int choiceGCD = 4;
    static final int choiceProgression = 5;
    static final int choicePrime = 6;
    public static void main(String[] args) {
        out.println("Please enter the game number and press Enter.");
        out.println("1 - Greet");
        out.println(choiceEven + " - Even");
        out.println(choiceCalc + " - Calc");
        out.println(choiceGCD + " - GCD");
        out.println(choiceProgression + " - Progression");
        out.println(choicePrime + " - Prime");
        out.println("0 - Exit");

        Scanner choice = new Scanner(System.in);
        System.out.print("Your choice: ");
        var gameChosen = choice.nextInt();

        if (gameChosen == 1) {
            Cli.getName();
        } else if (gameChosen == choiceEven) {
            Even.playEvenGame();
        } else if (gameChosen == choiceCalc) {
            Calc.playCalcGame();
        } else if (gameChosen == choiceGCD) {
            GCD.playGCDGame();
        } else if (gameChosen == choiceProgression) {
            Progression.playProgressionGame();
        } else if (gameChosen == choicePrime) {
            Prime.playPrimeGame();
        } else {
            System.exit(0);
        }
    }
}
