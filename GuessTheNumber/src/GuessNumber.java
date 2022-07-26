import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt(20)+1;
        int guesses = 0;
        int tries = 6;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hello! What is your name?\n");
        String userName = userInput.next();

        System.out.println("\nWell, "+ userName +", I am thinking of a number between 1 and 20.");

        while (guesses<=tries) {
            System.out.println("Take a guess.\n");

            String userGussString = userInput.next();
            int userGuessNumber = Integer.parseInt(userGussString);
            guesses++;

            if (num == userGuessNumber) {
                System.out.println("Good job, " + userName + "! You guessed my number in " + guesses + " guesses!");
                System.out.println("Would you like to play again? (y or n)\n");
                String again = userInput.next();

                if ('y' == again.charAt(0)) {
                    guesses = 0;
                    num = rand.nextInt(20) + 1;
                } else {
                    break;
                }
            } else if (num<userGuessNumber) {
                System.out.println("Your guess is too high.");
            } else if (num>userGuessNumber) {
                System.out.println("Your guess is too low.");
            }
        }

        if (guesses>tries){
            System.out.println("\nToo Many Guesses " + userName + ". You Lose");
        }

    }
}
