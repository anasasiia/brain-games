package hexlet.code;

import hexlet.code.games.*;

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
        out.println("1 - Greet");
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
            case CHOICE_EVEN -> Engine.runGame(Even.INSTRUCTION, Even.questions, Even.answers);
            case CHOICE_CALC -> Engine.runGame(Calc.INSTRUCTION, Calc.questions, Calc.answers);
            case CHOICE_GCD -> Engine.runGame(GCD.INSTRUCTION, GCD.questions, GCD.answers);
            case CHOICE_PROGRESSION -> Engine.runGame(Progression.INSTRUCTION, Progression.questions, Progression.answers);
            case CHOICE_PRIME -> Engine.runGame(Prime.INSTRUCTION, Prime.questions, Prime.answers);
            default -> System.exit(0);
        }
        choice.close();

    }
}
