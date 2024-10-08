import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // Do not modify the method signature.
    public static WordleGame startGame(Scanner scanner) throws FileNotFoundException {
        System.out.print("Enter a puzzlen number between 0-2315: ");
        int word = scanner.nextInt();
        WordleGame wordle = new WordleGame(word);
        return wordle;  // TODO - implement and replace me
    }

    // Do not modify the method signature.
    public static void playGame(Scanner scanner, WordleGame game) throws FileNotFoundException {
       
       while(!game.isGameOver()){
            System.out.println("Enter a five letter word");
            String guess = scanner.next();
            if(WordBank.checkInDictionary(guess)){
                game.guess(guess);

            }else{
            System.out.println("ENTER A VALID FIVE LETTER WORD!!!!");
            }
            System.out.println(game.toString());
        }
    }

    // Do not modify the method signature.
    public static void reportGameOutcome(WordleGame game) {
        if(game.isGameWin()){
            System.out.println("You won!");
        }else{
            System.out.println("The answer was: "+game.getAnswer());
        }
    }

    // This main method body should not be modified.
    public static void main(String[] args) throws FileNotFoundException {
        // Only use this Scanner for user input, do not create new ones via `new Scanner(System.in)`.
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }
}
