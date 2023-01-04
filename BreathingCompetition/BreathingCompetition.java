package MyPrograms.BreathingCompetition;

import java.util.Scanner;

public class BreathingCompetition 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("In this competition, each player will stop their breath for as long as they can");
		System.out.println("Each have 3 attempts and who ever has the highest average duration wins");
		
		
		System.out.println("How many players will there be in this competition?");
		if (scanner.hasNextInt())
		{
			int attempts = 3;
			double highest = 0.0;
			String highestPlayer = "";

			int numOfPlayers = scanner.nextInt();
			scanner.nextLine();
			Players[] player = new Players[numOfPlayers];
			for (int i = 0; i < numOfPlayers; i++)
			{
				player[i] = new Players();
				System.out.print("Name of Player " + (i+1) + ": ");
				player[i].setName(scanner.nextLine());
			}
			/* 
			Use scanner.next(); instead of scanner.nextLine();

			next() will find and return the next complete token from the input stream.
			nextLine() will advance the scanner past the current line and will return the input that was skipped
			*/
			System.out.println("Let us now start");
			while (attempts > 0)
			{
				for (int i = 0; i < numOfPlayers; i++)
				{
					System.out.println(player[i].getName() + ", how long did you stopped your breath?");
					if (scanner.hasNextDouble())
					{
						double duration = scanner.nextDouble();
						player[i].setBreathDuration(duration);
					}
					else
					{
						System.out.println("Error occurred, you might have entered a non numerical data");
						attempts = 0;
						break;
					}
				}
				attempts--;
			}

			for (int i = 0; i < numOfPlayers; i++)
			{
				player[i].setAverage(player[i].getBreathDuration());
				System.out.println("The average of " + player[i].getName() + " is " + player[i].getAverage());
				if (player[i].getAverage() > highest)
				{
					highest = player[i].getAverage();
					highestPlayer = player[i].getName();
				}
			}
			System.out.println("The highest is " + highest + ", so " + highestPlayer + " won!");
		}
		else
		{
			System.out.println("Error occurred, you might have entered a non numerical data");
		}
		
		
	}
}
