package hexlet.code.games;

import java.util.Scanner;

public class GCD {
    public static String instructionInGcdGame() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String questionInGcdGame() {
        var num1 = (int) (Math.random() * (50 + 1));
        var num2 = (int) (Math.random() * (50 + 1));
        return Math.abs(num1) + " " + Math.abs(num2);
    }

    public static int rightAnswerInGcdGame(String question) {
        Scanner scan = new Scanner(question);
        scan.useDelimiter(" ");
        int x = Integer.parseInt(scan.next());
        int y = Integer.parseInt(scan.next());

        var gcd = 0;

        if (x == y) {
            gcd = x;
        } else if (x % y == 0) {
            gcd = y;
        } else if (y % x == 0) {
            gcd = x;
        } else if (x > y) {
            for (var i = y; i > 0; i--) {
                if (x % i == 0 && y % i == 0) {
                    gcd = i;
                    break;
                }
            }
        } else if (y > x) {
            for (var i = x; i > 0; i--) {
                if (x % i == 0 && y % i == 0) {
                    gcd = i;
                    break;
                }
            }
        }
        return gcd;
    }
}
