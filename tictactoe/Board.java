package MyPrograms.tictactoe;

import java.util.Scanner;

public class Board 
{
	
	private final String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

	static Scanner scanner = new Scanner(System.in);
	
	public void showBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}
	
	public void game() 
	{
		int piecesPut = 0; // If its 9 and there's no winner then it's a tie
		String winner = null;
		
		while (winner == null)
		{
			for (int i = 0; i < 2; i++) // player interchange
			{
				int position;
				do { // while the input is invalid
					showBoard();
					System.out.println("Remember to enter a valid number from 1-9 and the slot should be empty");
					System.out.print("Player "+ (i+1) +": ");
					position = scanner.nextInt();
				}
				while (position < 1 || position > 9 || board[position - 1].equals("O") || board[position - 1].equals("X"));

				String moves = "OX";
				board[position - 1] = Character.toString(moves.charAt(i));
				piecesPut++;
				
				
				if (win().equals("p1") || win().equals("p2"))
				{
					winner = win().equals("p1") ? "Player 1" : "Player 2";
					// if winner equals p1 then Player 1 wins, if not then Player 2 Wins
					System.out.println(winner + " Wins!");
					break;
				}
				
				if (piecesPut == 9)
				{
					winner = "tie";
					System.out.println("Its a tie!");
					break;
				}
			}
		}
	}
		
		public String win()
		{
			String line = "";
			for (int i = 0; i < 8; i++)
			{
				switch (i) {
					case 0 -> line = board[0] + board[1] + board[2];
					case 1 -> line = board[0] + board[3] + board[6];
					case 2 -> line = board[0] + board[4] + board[8];
					case 3 -> line = board[1] + board[4] + board[7];
					case 4 -> line = board[2] + board[5] + board[8];
					case 5 -> line = board[3] + board[4] + board[5];
					case 6 -> line = board[6] + board[7] + board[8];
					case 7 -> line = board[2] + board[4] + board[6];
				}
				
				if (line.equals("OOO"))
				{
					return "p1";
				}
				if (line.equals("XXX"))
				{
					return "p2";
				}
			}
			return "None";
		}
	
	
	
}
