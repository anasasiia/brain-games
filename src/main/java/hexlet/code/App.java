package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

import static java.lang.System.out;


public class App {
    static final int CHOICE_EVEN = 2;
    static final int CHOICE_CALC = 3;
    static final int CHOICE_GCD = 4;
    static final int CHOICE_PROGRESSION = 5;
    static final int CHOICE_PRIME = 6;
    public static void main(String[] args) {
        out.println("Please enter the game number and press Enter.");
        out.println("1 - Greet");
        out.println(CHOICE_EVEN + " - Even");
        out.println(CHOICE_CALC + " - Calc");
        out.println(CHOICE_GCD + " - GCD");
        out.println(CHOICE_PROGRESSION + " - Progression");
        out.println(CHOICE_PRIME + " - Prime");
        out.println("0 - Exit");
        chooseGame();
    }

    public static void chooseGame() {
        Scanner choice = new Scanner(System.in);
        System.out.print("Your choice: ");
        var gameChosen = choice.nextInt();

        if (gameChosen == 1) {
            Cli.getName();
        } else if (gameChosen == CHOICE_EVEN) {
            Even.playEvenGame();
        } else if (gameChosen == CHOICE_CALC) {
            Calc.playCalcGame();
        } else if (gameChosen == CHOICE_GCD) {
            GCD.playGCDGame();
        } else if (gameChosen == CHOICE_PROGRESSION) {
            Progression.playProgressionGame();
        } else if (gameChosen == CHOICE_PRIME) {
            Prime.playPrimeGame();
        } else {
            System.exit(0);
        }
    }
}
