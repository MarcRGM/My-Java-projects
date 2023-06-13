package ATMGUICaseStudy;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class Bank {
    // Bank - This class represents the bank that owns the ATM and manages the accounts.
    // It has a HashMap called accounts which stores account objects keyed by the account holder's name.
    // It also has an ArrayList called pins, which stores all the generated PINs.

    static protected HashMap<String, Account> accounts = new HashMap<>();
    // HashMap is an unordered collection that stores elements in key-value pairs, allowing us to access them using a key.
    // The keys in a HashMap must be unique, while values can be duplicated.
    // HashMap is useful when we need to store a collection of objects that can be accessed efficiently using a key,
    // instead of an index.
    static protected ArrayList<StringBuilder> pins = new ArrayList<>();

    // Account Creation
    protected static void createAccount(StringBuilder pin, String name) {
        pins.add(pin);
        accounts.put(name, new Account(name, pin));
    }

    static StringBuilder createPin(int pinLength) {
        Random random = new Random();
        StringBuilder pin = new StringBuilder();
        // StringBuilder is used here for appending

        // Generate random number and append it to the pin, it will stop when it reaches the appropriate length
        boolean pinIsUnique = false;
        while (!pinIsUnique) {
            for (int i = 0; i < pinLength; i++) {
                pin.append(random.nextInt(10));
            }
            if (pins.contains(pin)) {
                pin.delete(0, pin.length());
            } else {
                pinIsUnique = true;
            }
        }
        return pin;
    }
    // The createPin() method generates a random PIN of either 4 or 6 digits depending on user input.
    // It returns a StringBuilder object that contains the PIN.

}




