package MyPrograms.hangman;

import java.util.Scanner;


public class Main 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Words words = new Words();
		
		
		
		System.out.println("Welcome to my own version of Hangman");
		System.out.println("The instructions are just the same so i wont explain that much");
		System.out.println("The only difference is spaces( ) and hypens(-) are counted here, dont worry since there are not that much words that contains those two"
				+ "\nYou can fully answer, if you already know the answer but if you're wrong your lives will be decremented" +
				"\n on the number of letters of the word you guessed minus the letters that are already guessed");
		System.out.print("1 Easy\n2 Medium\n3 Hard\n4 Really Hard\nEnter the number of your difficulty: ");
		int diff = scanner.nextInt();

		switch (diff) {
			case 1 -> {
				System.out.println("You have chosen the easy words category");
				new Game(words.getEasyWords());
			}
			case 2 -> {
				System.out.println("You have chosen the medium words category");
				new Game(words.getMediumWords());
			}
			case 3 -> {
				System.out.println("You have chosen the hard words category");
				new Game(words.getHardWords());
			}
			case 4 -> {
				System.out.println("You have chosen the really hard words category");
				new Game(words.getReallyHardWords());
			}
		}
		
	}
}
