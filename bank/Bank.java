package MyPrograms.bank;

import java.util.ArrayList;
import java.util.Scanner;


public class Bank
{
	private ArrayList<Account> accounts = new ArrayList<>();

	private static ArrayList<String> usernames = new ArrayList<>();
	private static ArrayList<String> passwords = new ArrayList<>();

	static Scanner scanner = new Scanner(System.in);


	void start()
	{
		System.out.println("Welcome to MM Bank");
		loop: while (true)
		{
			System.out.println("Enter 1 if you want to sign up\nEnter 2 if you want to sign in\nEnter 3 to exit the program");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice)
			{
				case 1 -> signUp();
				case 2 -> signIn();
				case 3 -> {
					System.out.println("Bye.");
					break loop;
				}
			}
		}
	}

	void signUp()
	{
		while (true) {
			System.out.print("Enter your username(spaces are invalid): ");
			String user = scanner.next();
			if (usernames.contains(user)) {
				System.out.println("There is already an account with that username, do you want to sign in? [y/n]");
				if (scanner.next().equalsIgnoreCase("y") || scanner.next().equalsIgnoreCase("yes")) {
					// scanner.nextLine() returns false while scanner.next() returns true...
					signIn();
					break;
				}
				continue;
			}
			usernames.add(user);
			System.out.print("Enter your password(spaces are invalid): ");
			String password = scanner.next();
			passwords.add(password);
			accounts.add(new Account()); 											 // the index of usernames, passwords, and accounts are the same
			System.out.println("Your account number is " + usernames.indexOf(user)); // the account number is the index of the three
			System.out.println("Congrats! your account has been created \nUsername: " + user
					+ "\nPassword: " + password);
			break;
		}
	}

	void signIn()
	{
		String pass;
		int index;
		String user;
		outer: while (true) {
			System.out.print("Enter your username (This is case sensitive and spaces are invalid): ");
			user = scanner.next();
			if (!usernameExist(user)) {
				System.out.println("Username is invalid, please try again");
				continue;
			}
			index = usernames.indexOf(user); // getting the index of the username since it's also the same in the password and accounts
			while (true) { // same pass don't work
				System.out.println("Enter S to go signup or B to go back to username login");
				System.out.print("Enter your password (This is case sensitive and spaces are invalid): ");
				pass = scanner.next();
				if (pass.equalsIgnoreCase("B")) continue outer;
				if (pass.equalsIgnoreCase("S")) signUp();
				if (!passwordExist(pass, index)) {
					System.out.println("Wrong password, please try again");
					continue;
				}
				break outer;
			}
		}
		loop: while (true) {
			System.out.println("Welcome!");
			System.out.println("""
					Enter 1 for Deposit
					Enter 2 for Withdraw
					Enter 3 to change your username
					Enter 4 to change your password
					Enter 5 to exit""");
			switch (scanner.nextInt()) {
				case 1 -> accounts.get(index).deposit();
				case 2 -> accounts.get(index).withdraw();
				case 3 -> accounts.get(index).changeUser(user, index);
				case 4 -> accounts.get(index).changePass(pass, index);
				case 5 -> {
					System.out.println("Bye!");
					break loop;
				}
			}
		}
	}

	public void setUsername(int index, String newUser)
	{
		usernames.set(index, newUser);
	}

	public void setPassword(int index, String newPass)
	{
		passwords.set(index, newPass);
	}

	static Boolean usernameExist(String user) // checks if there is an account wh
	{
		return usernames.contains(user);
	}

	static Boolean passwordExist(String pass, int index)
	{
		// if there are accounts with the same password, we will get the index of user's username since it is the same index of the password
		// and from the passwords Arraylist we will get the value in that index to compare it to the users password input
		return passwords.contains(pass) && pass.equalsIgnoreCase(passwords.get(index));
	}

	ArrayList getUsernames()
	{
		return usernames;
	}
}
