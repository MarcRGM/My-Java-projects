package MyPrograms.RockPaperScissors;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hey there! Do you want to play Rock, Papers, Scissors? [y/n]");
		if (scanner.nextLine().equalsIgnoreCase("Y") || scanner.nextLine().equalsIgnoreCase("YES"))
		{
			new Game();
		}
		else
		{
			System.out.println("Oke bye.");
		}
		
	}
}
