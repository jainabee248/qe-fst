package activities;

import java.util.Scanner;

public class RPSActivityManual {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Player 1 please enter rock, paper, or scissors: ");
        String player1 = scanner.nextLine().toLowerCase();

        System.out.print("Player 2 please enter rock, paper, or scissors: ");
        String player2 = scanner.nextLine().toLowerCase();

        determineWinner(player1, player2);

        scanner.close();
    }

    public static void determineWinner(String p1, String p2) {
        if (p1.equals(p2)) {
            System.out.println("It's a tie!");
        } else if ((p1.equals("rock") && p2.equals("scissors")) ||
                   (p1.equals("scissors") && p2.equals("paper")) ||
                   (p1.equals("paper") && p2.equals("rock"))) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}
