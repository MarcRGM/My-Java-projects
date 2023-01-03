package MyPrograms.RockPaperScissors;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Game {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	private int rounds = 0;
	private int botWins = 0;
	private int playerWins = 0;
	String playerChoice;
	int botChoice;
	
	
	Game() {
		System.out.println("How many rounds would you like to play?");
		rounds = scanner.nextInt();
		System.out.println("Let's start!");
		while (playerWins <= (rounds / 2) && botWins <= (rounds / 2)) {
			System.out.print("Yours: ");
			playerChoice = scanner.next().toLowerCase();
			botChoice = random.nextInt(3);
			// 0 = rock, 1 = paper, 2 = scissors
			switch(playerChoice) {
				case "rock" -> {
					switch (botChoice)
					{
						case 0 -> {
							System.out.println("Mine : rock");
							System.out.println("Tie!");
						}
						case 1 -> {
							System.out.println("Mine : paper");
							System.out.println("Haha you lost!");
							botWins++;
						}
						case 2 -> {
							System.out.println("Mine : scissors");
							System.out.println("Aww men..");
							playerWins++;
						}
					}
				}

				case "paper" -> {
					switch (botChoice) {
						case 0 -> {
							System.out.println("Mine : rock");
							System.out.println("Aww men..");
							playerWins++;
						}

						case 1 -> {
							System.out.println("Mine : paper");
							System.out.println("Tie!");
						}

						case 2 -> {
							System.out.println("Mine : scissors");
							System.out.println("Haha you lost!");
							botWins++;
						}
					}
				}

				case "scissors" -> {
					switch (botChoice) {
						case 0 -> {
							System.out.println("Mine : rock");
							System.out.println("Haha you lost!");
							botWins++;
						}

						case 1 -> {
							System.out.println("Mine : paper");
							System.out.println("Aww men..");
							playerWins++;
						}

						case 2 -> {
							System.out.println("Mine : scissors");
							System.out.println("Tie!");
						}
					}
				}
				default -> System.out.println("That is not a move");
			}
			System.out.println("\nYour wins: " + playerWins);
			System.out.println("My wins: " + botWins + "\n");
		}

		if (playerWins > botWins)
		{
			System.out.println("You won!");
		}
		else
		{
			System.out.println("You lost to me HAHAHAHAH!");
		}

	}
}

