package MyPrograms.Sticks31;
import java.util.Scanner;
// Need improvement
// The nextInt takes three inputs


public class Main
{
	public static void main(String[] args)
	{
		// 31 game
		Scanner scanner = new Scanner(System.in);
		System.out.println("The instructions are simple, both players will take turns in getting sticks, both can get 1 - 3 sticks each turn");
		System.out.println("The one who gets the last stick loses");

		System.out.println("Want to play with a bot? (Y/N)");
		if (scanner.next().equalsIgnoreCase("Y")|| scanner.next().equalsIgnoreCase("YES"))
		{
			new Bot();
		}
		else
		{
			new Player();
		}
		scanner.close();
	}
}
