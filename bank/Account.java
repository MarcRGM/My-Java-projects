package MyPrograms.bank;

import java.util.Scanner;

public class Account extends Bank
{
    static Scanner scanner = new Scanner(System.in);
    private double balance;

    void changeUser(String username, int index)
    {
        while (true) {
            System.out.print("Hello " + username
                    + ", Enter your new username: ");
            String newUser = scanner.next();
            System.out.println(getUsernames().toString());
            if (getUsernames().contains(newUser)) {
                System.out.println("Username is invalid");
                continue;
            }
            setUsername(index, newUser);
            System.out.println("Your new username is " + newUser);
            break;
        }
    }
    void changePass(String pass, int index)
    {
        while (true) {
            System.out.print("Enter your old password (Remember that this is case sensitive and spaces are invalid): ");
            if (!scanner.next().equalsIgnoreCase(pass)) {
                System.out.println("Wrong password, please try again");
                continue;
            }
            break;
        }
        System.out.print("Enter your new password (Remember that this is case sensitive and spaces are invalid): ");
        String newPass = scanner.next();
        setPassword(index, newPass);
        System.out.println("Your new password is " + newPass);
    }

    void deposit()
    {
        System.out.println("Balance: $" + balance);
        System.out.print("Deposit: ");
        balance += scanner.nextDouble();
        System.out.println("Balance: $" + balance);
    }

    void withdraw()
    {
        System.out.println("Balance: $" + balance);
        System.out.println("Withdraw: ");
        double withdrawn = scanner.nextDouble();
        System.out.println(withdrawn + "$ is withdrawn");
        balance -= withdrawn;
    }

}
