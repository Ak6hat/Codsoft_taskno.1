
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int rounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;

            System.out.println("Round " + (rounds + 1));
            System.out.println("Guess a number between 1 and 100");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Invalid guess. Try again.");
                    continue;
                }

                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed in " + attempts + " attempts.");
                    score += 10 - attempts; // Score based on attempts
                    rounds++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you didn't guess the number. It was " + numberToGuess);
            }

            System.out.println("Your current score: " + score);
            System.out.println("Rounds won: " + rounds);

            System.out.print("Play again? (y/n): ");
            char playAgainChoice = scanner.next().charAt(0);
            playAgain = (playAgainChoice == 'y' || playAgainChoice == 'Y');
        }

        scanner.close();
        System.out.println("Final Score: " + score);
        System.out.println("Total Rounds: " + rounds);
    }
}
