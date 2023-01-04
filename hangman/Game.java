package MyPrograms.hangman;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Game 
{
	ArrayList<String> letters = new ArrayList<String>();
	Random random = new Random();
	Stickman stickman = new Stickman();
	Scanner scanner = new Scanner(System.in);
	
	String answer;
	
	private int lives = 7;
	
	int guessedWord = 0;
	
	StringBuffer currentGuess = new StringBuffer(); // contains current guessed letters

	Game(String[] words)
	{
		answer = words[random.nextInt(60)];
		
		// The guess of the user
		currentGuess.append("-".repeat(answer.length()));
		
		// Shows the length of the word
		System.out.println("Here is the length of the word");
		for (int i = 0; i < answer.length(); i++)
		{
			System.out.print("-");
		}
		System.out.println();
		
		while (lives > 0)
		{
			System.out.print("Enter your letter: ");
			String letter = scanner.nextLine();

			// if the user input is more than one letter
			if (letter.length() != 1)
			{
				System.out.println("Choose 1 letter");
			}

			else {
				// Check the input of user if it's already chosen before
				if (letters.contains(letter)) {
					System.out.println("You already chose that letter try again");
				} else {
					if (answer.contains(letter)) {
						// If the user guess a word correctly, it shows the place of the correct word
						for (int i = 0; i < answer.length(); i++) {
							if (answer.charAt(i) == letter.charAt(0)) {
								currentGuess.replace(i, i + 1, letter);
								guessedWord++;
							}
						}
					}
					// if the word does not contain the letter and the letter haven't been input by the user
					else {
						System.out.println("The word does not contain that letter");
						lives--;
					}
					letters.add(letter);
				}

				System.out.println("\n" + currentGuess + "\n");

				System.out.println("Do you already know the answer? (y/n)");
				String resp = scanner.nextLine();
				if (resp.equalsIgnoreCase("y") || resp.equalsIgnoreCase("yes")) {
					System.out.print("Answer: ");
					String guess = scanner.nextLine();
					if (guess.equalsIgnoreCase(answer)) {
						System.out.println("You Won!");
						break;
					} else {
						// if there are correct letters in the word that the user guess, it will show in the correct answer while each wrong answer will decrease its lives
						System.out.println("Nice try...");
						for (int i = 0; i < guess.length(); i++) {
							if (answer.contains(String.valueOf(guess.charAt(i)))) { // adds the letters that are in the answer
								if (letters.contains(String.valueOf(guess.charAt(i)))) { continue; }
								else { letters.add(String.valueOf(guess.charAt(i))); }
							}
							else { lives--; }
						}
					}

				}

				// If the user already guessed the word
				if (guessedWord == answer.length()) {
					System.out.println("You guessed the word! Great Job! [Answer: " + answer + "]");
					break;
				}

				switch (lives) {
					case 7 -> System.out.println(stickman.fullLife());
					case 6 -> System.out.println(stickman.sixLives());
					case 5 -> System.out.println(stickman.fiveLives());
					case 4 -> System.out.println(stickman.fourLives());
					case 3 -> System.out.println(stickman.threeLives());
					case 2 -> System.out.println(stickman.twoLives());
					case 1 -> System.out.println(stickman.oneLife());
					case 0 -> System.out.println(stickman.dead());
				}
				System.out.println(currentGuess);

				// Shows the letters that the user already chose
				System.out.println("Here are the letters that you already chose " + letters.toString());
			}
		}
		if (lives == 0) {
			System.out.println("You lost your lives... the word is " + answer);
		}
	}
	
}
