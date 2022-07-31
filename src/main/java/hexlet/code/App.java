package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;


public class App {
    public static void main(String[] args) {

        out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit""");
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice: ");
        var gameChosen = sc.nextInt();

        if (gameChosen == 1) {
            Cli.getName();
        }

        if (gameChosen == 2) {
            Even.gameEven();
        }
    }
}
