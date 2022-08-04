import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class GuessNumberTest {

    GuessNumber guessNumber;
    @BeforeEach
    void setUp() {
        guessNumber = new GuessNumber();
    }

    @DisplayName("Test Great User")
    @Test
    void greetUser() {
        String name = "Kaymon";
        InputStream input = new ByteArrayInputStream(name.getBytes());
        guessNumber.setUserInput(new Scanner(input));
        String result = "\nWell, "+ name +", I am thinking of a number between 1 and 20.";
        assertEquals(result,guessNumber.greetUser(),"Greet User Failed");

    }

    @DisplayName("Test Low Guess")
    @Test
    void makeLowGuess() {
        guessNumber.setNumber(15);
        InputStream input = new ByteArrayInputStream("10".getBytes());
        guessNumber.setUserInput(new Scanner(input));
        String result = "Your guess is too low.";
        assertEquals(result,guessNumber.makeGuess(),"Make low guess failed");
    }

    @DisplayName("Test High Guess")
    @Test
    void makeHighGuess() {
        guessNumber.setNumber(5);
        InputStream input = new ByteArrayInputStream("10".getBytes());
        guessNumber.setUserInput(new Scanner(input));
        String result = "Your guess is too high.";
        assertEquals(result,guessNumber.makeGuess(),"Make High guess failed");
    }

    @DisplayName("Test Equal Guess")
    @Test
    void makeEqualGuess() {
        guessNumber.setNumber(10);
        guessNumber.setUserName("User");
        InputStream input = new ByteArrayInputStream("10".getBytes());
        guessNumber.setUserInput(new Scanner(input));
        String result = "Good job, " + guessNumber.getUserName() + "! You guessed my number in " + 1 + " guesses!";
        assertEquals(result,guessNumber.makeGuess(),"Make Equal guess failed");
    }

    @DisplayName("Test Guess Exception")
    @Test
    void makeGuessException() {
        guessNumber.setNumber(10);
        guessNumber.setUserName("User");
        InputStream input = new ByteArrayInputStream("1.5".getBytes());
        guessNumber.setUserInput(new Scanner(input));
        String result = "Guessed number is invalid... That counts as a guess. You have " + 5 + " guesses left";
        assertEquals(result,guessNumber.makeGuess(),"Make guess exception failed");
    }

    @DisplayName("Test Play Again Yes")
    @Test
    void doPlayAgainYes() {
        InputStream input = new ByteArrayInputStream("y".getBytes());
        guessNumber.setUserInput(new Scanner(input));
        guessNumber.doPlayAgain();
        assertTrue(guessNumber.getPlayAgain(),"Yes play again failed");
    }

    @DisplayName("Test Play Again No")
    @Test
    void doPlayAgainNo() {
        InputStream input = new ByteArrayInputStream("n".getBytes());
        guessNumber.setUserInput(new Scanner(input));
        guessNumber.doPlayAgain();
        assertFalse(guessNumber.getPlayAgain(),"No play again failed");
    }

    @AfterEach
    void tearDown(){
        if (guessNumber.getUserInput()!=null){
            guessNumber.closeScanner();
        }
    }
}