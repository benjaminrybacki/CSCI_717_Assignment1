import java.util.Scanner;

/**
 * EncryptionMachine.java
 * This program lets you encrypt a message with a key for your recipient to decrypt!
 * The program prompts the user for a key word, the number of words to encrypt,
 * and the words to encrypt. The program then encrypts the words and prints them.
 *
 * @author brybacki
 * @version 2023-09-27
 */
public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;

    /**
     * The main method of the program.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to the CSCI717 Encryption Machine Construction!
                The program lets you encrypt a message
                with a key for your recipient to decrypt!
                """);

        // prompt user to enter a key word to encrypt, then encrypt it
        String key = queryUserForInput("Enter a key word:", scanner);
        encryptWord(key);

        String wordCountString =
                queryUserForInput("How many words would you like to encrypt?", scanner);
        int wordCount = Integer.parseInt(wordCountString);

        // prompt user for number of words they specified, encrypting each one
        for(int i = 0; i < wordCount; i++) {
            String word = queryUserForInput("Enter a word to encrypt:", scanner);
            encryptWord(word);
        }

        System.out.println("Message fully encrypted. Happy secret messaging!");
        scanner.close();
    }

    /**
     * Prompts the user for input of some kind.
     * @param messagePrompt The message to prompt the user with.
     * @param scanner The scanner to use to get the user's input.
     * @return The input the user entered.
     */
    private static String queryUserForInput(String messagePrompt, Scanner scanner) {
        System.out.println(messagePrompt);
        String word = scanner.nextLine();
        return word;
    }

    /**
     * Encrypts a word by shifting each letter.
     * @param word The word to shift.
     * @return The shifted word.
     */
    private static String encryptWord(String word) {
        StringBuilder newWord = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);
            char newLetter = shiftLetter(currentLetter);
            newWord.append(newLetter);
        }
        System.out.println(word + " --Encrypted--> " + newWord);
        return newWord.toString();
    }

    /**
     * Shifts a letter over in the alphabet by a constant "SHIFT" amount.
     * @param c The letter to shift.
     * @return The shifted letter.
     */
    private static char shiftLetter(char c) {
        int index = ALPHABET.indexOf(c);
        int shiftedIndex = (index + SHIFT) % ALPHABET.length(); // wrap around alphabet if needed
        return ALPHABET.charAt(shiftedIndex);
    }

}
