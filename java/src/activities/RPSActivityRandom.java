package activities;

import java.util.Random;

public class RPSActivityRandom {

    public static void main(String[] args) {
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        String playerChoice = choices[random.nextInt(3)];

        String computerChoice = choices[random.nextInt(3)];

        System.out.println("Player choose: " + playerChoice);
        System.out.println("Computer chose: " + computerChoice);

        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (playerChoice.equals("scissors") && computerChoice.equals("paper")) ||
                   (playerChoice.equals("paper") && computerChoice.equals("rock"))) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}

