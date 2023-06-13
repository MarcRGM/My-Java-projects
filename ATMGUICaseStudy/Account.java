package ATMGUICaseStudy;


public class Account extends Bank{
    // This class represents a bank account and contains the account pin, username, and balance.
    // It also have methods for depositing and withdrawing money from the account.

    private int balance;

    // Not necessarily needed but it's here in case the accounts name is needed
    private String name;

    // StringBuilder is used when changing PIN or creating PIN
    private StringBuilder pin;

    Account(String name, StringBuilder tempPin) {
        this.name = name;
        pin = tempPin;
    }

    void changeName(String name, String newName) {
        accounts.put(newName, accounts.get(name)); // replacing
        accounts.remove(name);
        this.name = newName;
    }

    // change PIN
    void changePin(StringBuilder newPin) {
        pins.remove(pin);
        pins.add(newPin);
        this.pin = newPin;
    }

    void withdraw(int withdrawAmount) {
        balance -= withdrawAmount;
    }

    void deposit(int cashAmount) {
        balance += cashAmount;
    }

    void transferFunds(String receiver, int transferAmount) {
        // Transfering
        accounts.get(receiver).balance += transferAmount;

        // Decrement balance
        balance -= transferAmount;
    }

    int getBalance() {
       return balance;
    }
    
    String getPin() {
        return pin.toString();
    }
}

