package MyPrograms.Sticks31;
import java.util.Random;
import java.util.Scanner;

public class Bot
{
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	int player;
	int bot;

	int sticks = 31;

	boolean noWinner = true;

	Bot()
	{
		System.out.println("Do you want to be the first one to get the stick? [y/n]");
		if (scanner.next().equalsIgnoreCase("Y") || scanner.next().equalsIgnoreCase("YES"))
		{
			player = 0;
			bot = 1;
		}
		else
		{
			bot = 0;
			player = 1;
		}

		while (noWinner)
		{
			for (int i = 0; i < 2; i++) // Interchange with player and bot
			{
				if (sticks == 1)
				{
					if (bot == i)
					{
						System.out.println("You WON!");
					}
					else
					{
						System.out.println("You LOST!");
					}
					noWinner = false;
					break;
				}

				if (i == bot) {
					int botStick = random.nextInt(4);
					if (botStick == 0) { // if random number is 0 then it will just be 1
						botStick = 1;
					}
					System.out.println("Bot: " + botStick);
					continue;
				}

				System.out.print("Player: ");
				int get = scanner.nextInt();
				if (get >= 4 || get < 0)
				{
					System.out.println("Invalid. Try Again");
					i--;
				}
				sticks -= get;
			}
			System.out.println("Total Sticks: " + sticks);
		}
		scanner.close();
	}
	
	
}
