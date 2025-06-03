package activities;

import java.util.Scanner;
import java.util.Random;

public class RPSRandom {
	 public static void determineWinner(String player, String computer) {
	        if (player.equals(computer)) {
	            System.out.println("It's a tie!");
	        } 
	        else if ((player.equals("rock") && computer.equals("scissors")) ||
	                   (player.equals("scissors") && computer.equals("paper")) ||
	                   (player.equals("paper") && computer.equals("rock"))) {
	            System.out.println("Player wins!");
	        } else {
	            System.out.println("Computer wins!");
	        }
	    }
	


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        String player;

        
        while (true) {
            System.out.print("Player, please enter rock, paper, or scissors: ");
            player = scanner.nextLine().toLowerCase();

            if (player.equals("rock") || player.equals("paper") || player.equals("scissors")) {
                break; 
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        String computer = choices[random.nextInt(3)];

        System.out.println("Computer choose: " + computer);

        determineWinner(player, computer);

        scanner.close();
    }
}

   
