package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;
import static java.lang.System.out;


public class App {
    static final int CHOICE_CLI = 1;
    static final int CHOICE_EVEN = 2;
    static final int CHOICE_CALC = 3;
    static final int CHOICE_GCD = 4;
    static final int CHOICE_PROGRESSION = 5;
    static final int CHOICE_PRIME = 6;

    public static void main(String[] args) {
        out.println("Please enter the game number and press Enter.");
        out.println(CHOICE_CLI + " - Greet");
        out.println(CHOICE_EVEN + " - Even");
        out.println(CHOICE_CALC + " - Calc");
        out.println(CHOICE_GCD + " - GCD");
        out.println(CHOICE_PROGRESSION + " - Progression");
        out.println(CHOICE_PRIME + " - Prime");
        out.println("0 - Exit");

        Scanner choice = new Scanner(System.in);
        System.out.print("Your choice: ");
        var gameChosen = choice.nextInt();

        switch (gameChosen) {
            case CHOICE_CLI -> Cli.greetUser();
            case CHOICE_EVEN -> Even.runEven();
            case CHOICE_CALC -> Calc.runCalc();
            case CHOICE_GCD -> GCD.runGCD();
            case CHOICE_PROGRESSION -> Progression.runProgression();
            case CHOICE_PRIME -> Prime.runPrime();
            default -> System.exit(0);
        }
        choice.close();

    }
}
