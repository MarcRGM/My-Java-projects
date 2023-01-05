package MyPrograms.tictactoe;

public class Main 
{
	public static void main(String[] args)
	{
		Board board = new Board();
		
		System.out.println("Lets Play Tic Tac Toe!");
		System.out.println("The Board will show numbers where you can put your pieces");
		board.showBoard();
		System.out.println("Enter the number where you would like to put your piece");
		System.out.println("Player 1 = O and Player 2 = X");
		
		board.game();

	}
}
