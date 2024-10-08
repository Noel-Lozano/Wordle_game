import java.io.FileNotFoundException;
public class WordleGame {
  // TODO - implement according to spec
  private WordleLetter[][] wordleLetters = new WordleLetter[6][5];
  private int puzzleNumber;
  private String answer;
  private String guessWord;
  private int guessNumber = 0;


  public WordleGame(int puzzleNumber)throws FileNotFoundException {
    this.answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber);
    this.puzzleNumber = puzzleNumber;
  }
  public String getAnswer(){
    return this.answer;
  }
  
  public void guess(String guessWord){
    for (int i = 0; i < 5; i++) {
      char c = guessWord.charAt(i);
      String color = "red";
 
      if (c == answer.charAt(i)) {
          color = "green";
      } else if (answer.indexOf(c) >= 0) {
          color = "yellow";
      }
 
      wordleLetters[guessNumber][i] = new WordleLetter(c);
      wordleLetters[guessNumber][i].setColor(color);
    }
    guessNumber++;
  }

  public int getNumberGuessesSoFar(){
    return guessNumber;
  }

  public WordleLetter[] getGuess(int guessNumber){
    return wordleLetters[guessNumber]; 
  }

  public boolean isGameOver(){
    if(guessNumber == 6 || isGameWin()){
      return true;
    }
    return false;
  }
  
  public boolean isGameWin(){
    if(guessNumber == 0){
      return false;
    }
    for(int i = 0; i < wordleLetters[guessNumber-1].length; i++){
      if(!wordleLetters[guessNumber-1][i].isGreen()){
        return false;
      }
    }
    return true;
  }

  public String toString() {
    // result will be used to build the full answer String
    String result = "";
  //   // for each word guessed so far
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
      // get each letter of each word
      for (int j = 0; j < 5; j++) {
        // concatenate it to the result
        // WordleLetter's toString() is automatically invoked here.
        result += getGuess(i)[j];
      }
      // new line separator between each word
      result += "\n";
    }
    return result;
  }
}
