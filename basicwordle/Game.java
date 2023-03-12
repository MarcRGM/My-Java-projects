package basicwordle;

import java.util.Scanner;

public class Game {
    // Basic Wordle
    // Just like the wordle game, but it's text based
    // if the user input has one of the letters,
    // then the program will inform the user whether its on the right place or not
    // you only have 5 lives, every  mistake will cost you one
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my version of Wordle");

        String answer = new Words().getRandom();


        int lives = 5;
        while (lives != 0) {

            String usersWord;
            do {
                System.out.print("Input your word: ");
                usersWord = scanner.nextLine();
            } while (usersWord.length() != 5);

            checkLetter(usersWord, answer);

            if (usersWord.equalsIgnoreCase(answer)) {
                System.out.println("Congratulations, you've guessed the word!");
                break;
            }
            else { lives--; }
        }

        System.out.println("Answer: " + answer);


    }

    static void checkLetter(String usersWord, String answer) {
        for (int i = 0; i < 5; i++) {
            char letter = usersWord.charAt(i);
            if (!answer.contains(Character.toString(letter))) {
                continue;
            }
            if (answer.charAt(i) != letter) {
                System.out.println("The letter " + letter + " is in the wrong position!");
                continue;
            }
            System.out.println("The letter " + letter + " is in the correct position!");
        }
    }
}
