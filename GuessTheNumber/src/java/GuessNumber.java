
import java.util.Random;
import java.util.Scanner;


public class GuessNumber {

    private final Random rand = new Random();
    private final int tries = 6;
    private Scanner userInput;
    private int number = rand.nextInt(20)+1;
    private int userGuessNumber;
    private int guesses = 0;
    private String userName;

    private boolean playAgain = true;

    public void playGuessNumber(){
        setUserInput(new Scanner(System.in));
        System.out.println("Hello! What is your name?\n");
        System.out.println(greetUser());


        while (!userName.isEmpty() && playAgain) {
            System.out.println("Take a guess.\n");


            //User loses
            if (guesses==tries){
                System.out.println("\nToo Many Guesses " + userName + ". You Lose");
                doPlayAgain();
            }else {
                //User makes guess
                System.out.println(makeGuess());
                //Correct then ask to play again
                if (this.number==this.userGuessNumber){
                    doPlayAgain();
                }
            }

        }


    }

    public String greetUser(){

        try{
            setUserName(this.userInput.next());
            return "\nWell, "+ this.userName +", I am thinking of a number between 1 and 20.";
        }catch (Exception e){
            return "\nUser name is invalid";
        }
    }

    public String makeGuess() {
        String result = "";
        try {
            setUserGuessNumber(this.userInput.nextInt());
            this.guesses++;

            if (this.number == this.userGuessNumber) {
                result += "Good job, " + userName + "! You guessed my number in " + guesses + " guesses!";

            } else if (this.number < this.userGuessNumber) {
                result += "Your guess is too high.";
            } else {
                result += "Your guess is too low.";
            }

        } catch (Exception e) {
            result += "Guessed number is invalid... That counts as a guess. You have " + (tries - guesses) + " guesses left";
        }
        return result;
    }

    public void doPlayAgain(){
        System.out.println("Would you like to play again? (y or n)\n");
        try {
            char again = this.userInput.next().charAt(0);
            if (again == 'y') {
                setPlayAgain(true);
                setGuesses(0);
                setNumber(rand.nextInt(20) + 1);
            } else if ('n'==again) {
                setPlayAgain(false);
                closeScanner();
            }else {
                System.out.println("\nNope... y for yes or n for no");
                doPlayAgain();
            }
        } catch (Exception e) {
            System.out.println("Very bad input. Good Bye and Good Day");
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPlayAgain(boolean playAgain){
        this.playAgain = playAgain;
    }

    public void setGuesses(int guesses){
        this.guesses = guesses;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public void setUserGuessNumber(int userGuessNumber) {
        this.userGuessNumber = userGuessNumber;
    }

    public void setUserInput(Scanner userInput) {
        this.userInput = userInput;
    }

    public String getUserName() {
        return userName;
    }

    public boolean getPlayAgain() {
        return playAgain;
    }

    public int getGuesses() {
        return guesses;
    }

    public int getTries() {
        return tries;
    }

    public Scanner getUserInput() {
        return userInput;
    }

    public void closeScanner(){
        this.userInput.close();
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        guessNumber.playGuessNumber();
    }
}
