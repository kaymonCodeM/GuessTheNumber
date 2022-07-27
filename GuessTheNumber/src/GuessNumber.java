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
        String userName = "";

        try{
            userName += userInput.next();

            System.out.println("\nWell, "+ userName +", I am thinking of a number between 1 and 20.");
        }catch (Exception e){
            System.out.println("\nUser name is invalid");
        }


        while (guesses<=tries && !userName.isEmpty()) {
            System.out.println("Take a guess.\n");

            String userGussString = userInput.next();
            int userGuessNumber;

            try {
                userGuessNumber = Integer.parseInt(userGussString);

                if (num == userGuessNumber) {
                    System.out.println("Good job, " + userName + "! You guessed my number in " + guesses + " guesses!");
                    System.out.println("Would you like to play again? (y or n)\n");
                    String again;

                    try {
                        again = userInput.next();

                        if ('y' == again.charAt(0)) {
                            guesses = 0;
                            num = rand.nextInt(20) + 1;
                        } else {
                            break;
                        }

                    }catch (Exception e){
                        System.out.println("Very bad input. Good Bye and Good Day");
                        break;
                    }

                } else if (num<userGuessNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

            }catch (Exception e){
                System.out.println("Guessed number is invalid... That counts as a guess. You have " + (tries-(guesses+1)) + " guesses left");
            }
            guesses++;
        }

        if (guesses>tries){
            System.out.println("\nToo Many Guesses " + userName + ". You Lose");
        }

    }
}
