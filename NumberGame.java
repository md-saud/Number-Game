import java.util.Scanner;

public class NumberGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 5;
    
    private int secretNumber;
    private int attempts;
    private Scanner scanner;

    public NumberGame() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean playAgain = true;
        while (playAgain) {
            playRound();
            System.out.println("Do you want to play again? (yes/no)");
            String choice = scanner.next();
            playAgain = choice.equalsIgnoreCase("yes");
        }
        scanner.close();
    }

    private void playRound() {
        System.out.println("Welcome to the Number Game!");
        secretNumber = generateRandomNumber(MIN_RANGE, MAX_RANGE);
        attempts = 0;
        int guess;
        while (true) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
            if (attempts >= MAX_ATTEMPTS) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + secretNumber);
                break;
            }
        }
    }

    private int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
