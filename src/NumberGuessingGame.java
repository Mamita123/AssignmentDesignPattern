import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame extends Game {
    private int secretNumber;
    private int[] guesses;
    private int currentPlayer;



    @Override
    public void initializeGame(int numberOfPlayers){
        //Initialize the game by generating a random secret number
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1; //Random number between 1 and 100
        guesses = new int[numberOfPlayers];
        currentPlayer = 0;
        System.out.println(" Number Guessing Game Started!  Please try to guess the secret number between 1 and 100.");
    }

    @Override
    public boolean endOfGame() {
        //Check if any player has guessed the correct number
        for (int guess : guesses) {
            if (guess == secretNumber) {
                return true;  //if any player has guessed the correct number
            }
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        //Prompt the player to enter their guess
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + (player + 1) + ", Please enter your guess number: ");
        int guess = scanner.nextInt();
        guesses[player] = guess;

        //Provide feedback to the player based on their guess
        if (guess < secretNumber) {
            System.out.println(("The number is smaller! Please Try again."));

        } else if (guess > secretNumber) {
            System.out.println("The number is greater than secret number. Please Try again.");

        } else {
            System.out.println("Congartulations! Player " + (player + 1) + " has guessed the secret number " + secretNumber + " correctly!");
        }
    }

    @Override
    public void displayWinner(){
        //Display the winner or announce if no one guessed the correct number
        boolean winnerFound = false;
        for (int i = 0; i < guesses.length; i++){
            if (guesses[i] == secretNumber){
                System.out.println("Player" + (i + 1 ) + "wins!");
                winnerFound = true;
            }
        }
        if (!winnerFound){
            System.out.println("No one guessed the correct number. The secret number was: " + secretNumber);
        }
    }
}

