package MyPrograms.Sticks31;
import java.util.Scanner;

public class Player
{
	Scanner scanner = new Scanner(System.in);
	int sticks = 31;
	boolean noWinner = true;
	Player()
	{
		System.out.println("Take turns");
		System.out.println();
		System.out.println();
		while (noWinner)
		{
			for (int i = 1; i <= 2; i++) // iterate each player
			{
				if (sticks == 1)
				{
					System.out.println("Player " + i + " Loses");
					noWinner = false;
				}
				System.out.print("Player " + i + ":");
				int get = scanner.nextInt();
				if (get >= 4 || get < 0)
				{
					System.out.println("Invalid. Try Again");
					i--;
					continue;
				}
				sticks -= get;
				System.out.println("Current total of sticks: " + sticks);
			}
			
		}
		scanner.close();
	}
}














