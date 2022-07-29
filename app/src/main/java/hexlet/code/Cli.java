package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void getName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("May I have your name?");

        var name = sc.nextLine();
        System.out.println("Hello, " + name);
    }
}
