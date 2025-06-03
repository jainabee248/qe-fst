package activities;

public class Winner {
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
