package hexlet.code;

import hexlet.code.games.Progression;

import static java.lang.System.out;


public class App {
    public static void main(String[] args) {
        final int choiceEven = 2;
        final int choiceCalc = 3;
        final int choiceGCD = 4;
        final int choiceProgression = 5;

        out.println("Please enter the game number and press Enter.");
        out.println("1 - Greet");
        out.println(choiceEven + " - Even");
        out.println(choiceCalc + " - Calc");
        out.println(choiceGCD + " - GCD");
        out.println(choiceProgression + " - Progression");
        out.println("0 - Exit");

        Engine.games();
    }
}
