import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;


public class GuessNumber {

    private final Random rand = new Random();

    private InputStream in = System.in;
    private final int tries = 6;
    private int number = rand.nextInt(20)+1;
    private int userGuessNumber;
    private int guesses = 0;
    private String userName;

    private boolean playAgain = true;

    public void playGuessNumber(){
        System.out.println("Hello! What is your name?\n");
        System.out.println(greetUser());


        while (guesses<=tries && !userName.isEmpty() && playAgain) {
            System.out.println("Take a guess.\n");

            guesses++;
            System.out.println(makeGuess());

            if (this.number==this.userGuessNumber){
                doPlayAgain();
            }

        }

        if (guesses>tries){
            System.out.println("\nToo Many Guesses " + userName + ". You Lose");
        }


    }

    public String greetUser(){
        Scanner userInput = new Scanner(in);
        try{
            setUserName(userInput.next());
            return "\nWell, "+ this.userName +", I am thinking of a number between 1 and 20.";
        }catch (Exception e){
            return "\nUser name is invalid";
        }
    }

    public String makeGuess() {
        String result = "";
        Scanner userInput = new Scanner(in);

        try {

            setUserGuessNumber(Integer.parseInt(userInput.next()));

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
        Scanner userInput = new Scanner(in);
        try {
            char again = userInput.next().charAt(0);
            if (again == 'y') {
                setPlayAgain(true);
                setGuesses(0);
                setNumber(rand.nextInt(20) + 1);
            } else if ('n'==again) {
                setPlayAgain(false);
            }else {
                System.out.println("Nope... y for yes or n for no");
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

    public void setIn(InputStream in) {
        this.in = in;
    }

    public void setUserGuessNumber(int userGuessNumber) {
        this.userGuessNumber = userGuessNumber;
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


    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        guessNumber.playGuessNumber();
    }
}
