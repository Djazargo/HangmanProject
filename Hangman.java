import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

  
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String randomWord = getRandomWord(); // random word from function

        char[] randomWordArray = stringToCharArray(randomWord); // array of chars from String randomWord

        char[] wordArray = new char[randomWordArray.length]; // defined wordArray for work with comparasions
        for(int i = 0; i < randomWordArray.length; i++){    // now fill with '_' symbols
            wordArray[i] = '_';
        }

        char[] missArray = new char[5]; // array for missed chars
     
        boolean missCheck = false;      // boolean variable used in while loop, described there

        int phase = 1;
        while(true){

            System.out.print(phasesOfGallow(phase));
            
            if(phase == 7){                     // check LOOSE: if phase is 7 its game over you lost
                System.out.print("RIP!");
                System.out.println("\n");
                System.out.println("The word was: " + randomWord);
                break;
            }            
            
            System.out.print("Word: ");
            print1DArray(wordArray);            // prints wordArray with function
            
            if(Arrays.equals(wordArray, randomWordArray)){     // check WIN: check if wordArray == randomWordArray
                System.out.println("GOOD WORK! YOU WON!");
                break;
            }

            System.out.print("Misses: ");
            print1DArray(missArray);            // prints missArray with function
            
            System.out.print("Guess: ");
            char userGuess = scan.next().charAt(0);  // character input with (charAt(0); - work around for input only one character
            
            // makes copy of array and saves it in word array, compareUpdate funtion used for check input
            wordArray = Arrays.copyOf(compareUpdate(wordArray, randomWordArray, userGuess), randomWordArray.length);    
            
            missCheck = (miss(wordArray, userGuess));

            if (missCheck == false){                            // if missCheck = false add userGuess to missArray + phase++ for change phasesOfGallow
                for(int i = 0; i < missArray.length; i++){      // Adding an element to the first empty missArray's index
                    if(missArray[i] == 0) {
                        missArray[i] = userGuess;
                        break;
                    }
                }
                phase++; // phase++ for change phasesOfGallow
            }
        } 
    }

    // check if char input is in wordArray, return true of false

    public static boolean miss(char[] wordArray, char userGuess){

        boolean charMiss = true;

        for(int i = 0; i < wordArray.length; i++){
            if(wordArray[i] == userGuess){
                charMiss = true;
                break;
                
            } else {
                charMiss = false;
                
            }
        }
        
        return charMiss;
      
    }
  
    // print 1D array

    public static void print1DArray(char[] array){
           
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");                           
        }
        System.out.println("\n");

    }

    // get random word from predefined word array

    public static String getRandomWord() {
        
        String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
        "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
        "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
        "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
        "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
        "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
        "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
        "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
        "wombat", "zebra"};
        
        double randomNumber = Math.random() * words.length; // get random number from 0 to 63 (words.length)
        int intRandomNumber = (int)randomNumber;            // transfer to int

        String randomWord = words[intRandomNumber];         // take word from array

        return randomWord;

    }

    // array of chars from String

    public static char[] stringToCharArray(String word){

        char[] wordArray = new char[word.length()];       // define new char array 

        for (int i = 0; i < word.length(); i++){          // fill char array with chars from word string
            wordArray[i] = word.charAt(i);                // charAt() 
        }

        return wordArray;
        
    }

    // compare char array with user input and add chars to array

    public static char[] compareUpdate(char[] wordArray, char[] randomWordArray, char userGuess){

        char[] compareArray = new char[randomWordArray.length];
        
        for(int i = 0; i < randomWordArray.length; i++){
            if(randomWordArray[i] == userGuess){
                compareArray[i] = userGuess;
            } else {
                compareArray[i] = '_';
            }

        }

        char[] returnArray = new char[randomWordArray.length];

        for(int i = 0; i < randomWordArray.length; i++){
            if(wordArray[i] != '_'){
                returnArray[i] = wordArray[i];
            } else if (wordArray[i] == '_' && compareArray[i] != '_'){
                returnArray[i] = compareArray[i];
            } else if (wordArray[i] == '_' && compareArray[i] == '_'){
                returnArray[i] = '_';
            }
        }

        return returnArray;

    }

    // return phase of gallow to print statement in main class

    public static String phasesOfGallow(int number){

        switch (number) {
            case 1:   
            return 
            "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n";
            case 2:   
            return 
            "+---+\n" +
            "|   |\n" +
            "O   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n";
            case 3:   
            return 
            "+---+\n" +
            "|   |\n" +
            "O   |\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n";
            case 4:   
            return 
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|   |\n" +
            "     |\n" +
            "     |\n" +
            " =========\n";
            case 5:   
            return 
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n" + 
            "     |\n" +
            "     |\n" +
            " =========\n";
            case 6:   
            return 
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n" +
            "/    |\n" +
            "     |\n" +
            " =========\n";
            case 7:   
            return 
            " +---+\n" +
            " |   |\n" +
            " O   |\n" +
            "/|\\  |\n" + 
            "/ \\  |\n" +
            "     |\n" +
            " =========\n" +
            "          \n";

            default: 
            return "This shouldn't get called.";
        }
    }
}
 
