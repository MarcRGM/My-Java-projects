package ATMGUICaseStudy;

import javax.swing.*; // import all Swing components
import java.awt.*;  // contains classes for creating user interface
import java.awt.event.*;

public class ATMGUI extends Bank implements ActionListener {
    // This class represents the ATM machine itself and should contain the methods for handling transactions,
    // such as withdrawing and depositing money, checking the balance, and so on.

    // Authentication: The ATM must verify the identity of the user before providing any service.
    // This can be done by using a PIN number

    // Cash withdrawal: The user should be able to withdraw cash from their account by entering the amount they wish to withdraw.
    // The ATM must check if the user has enough balance in their account before dispensing the cash.

    // Balance inquiry: The user should be able to check their account balance by entering their account number and PIN.

    // Withdrawal limit: The ATM can set a limit on the amount of cash that can be withdrawn per transaction or per day.

    // Cash deposit: The user should be able to deposit cash into their account using the ATM.
    // The ATM must count and validate the deposited cash and update the user's account balance.

    // Transfer funds: The user should be able to transfer funds from their account to another account by
    // entering the recipient's account number and the amount to be transferred.
    // The ATM must verify the availability of funds and update the account balances accordingly.

    // MAIN Frame
    private JFrame frame = new JFrame();

    // ATM label
    private JLabel atm = new JLabel();

    private static JTextField firstTextField, secondTextField ;

    // label for letters
    private JLabel firstRowLetters, secondRowLetters, thirdRowLetters;

    // Main Panel
    private JPanel panel = new JPanel();
    private JButton[] numberButtons = new JButton[10];	// holds number through 0-9

    private JButton cancelButton = new JButton();
    private JButton clearButton = new JButton();
    private JButton enterButton = new JButton();

    // PAGES:
    // Start, SignUpUsername, SignUpPin, ShowSignUpDetails, EnterUsername, EnterPin,
    // ShowAtmFunctions, Deposit, Withdraw, Balance, TransferFundsTo, TransferAmount, ChangeName, NewName, ChangePin, NewPin, showNewPin
    private String currentPage = "Start";

    private final int BALANCE_WITHDRAW_LIMIT = 50000;


    // sign up instances
    private String tempUsername;
    private StringBuilder tempPin;

    // sign in instances
    private  String username;

    // Transfer funds instances
    String receiver;
    int transferAmount;

    ATMGUI() {
        // SETTING UP FRAME
        frame.setTitle("atm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null); // Put the location in the middle
        // According to JavaDoc: If the component is null,
        // or the GraphicsConfiguration associated with this component is null,
        // the window is placed in the center of the screen.

        // MAIN PANEL
        panel.setBounds(95, 75, 600, 250); // Position(x position, y position, width, height)
        panel.setBackground(new Color(60, 80, 0));
        panel.setBorder(BorderFactory.createLineBorder(new Color(10, 30, 0), 10)); // Create border(color, thickness)
        panel.setLayout(null); // avoid default layout

        // ATM LABEL
        atm.setText("ATM"); // set text	of atm
        atm.setForeground(new Color(200, 200,200));	// set the font color of the text using either RGB(0,0,0) or hexadecimal(0x000000)
        atm.setFont(new Font("Arial",Font.BOLD,40));	// set the font of text ("font",Font."style of the font","size of font"
        atm.setBackground(new Color(50, 50, 50));    // set background color
        atm.setOpaque(true);	// display background color
        atm.setBorder(BorderFactory.createLineBorder(Color.darkGray, 30)); // set the border that you created
        atm.setVerticalAlignment(JLabel.TOP);			// set vertical position of text within atm
        atm.setHorizontalAlignment(JLabel.CENTER);		// set horizontal position of text within atm



        // BUTTONS
        createButtons();
        // Add the buttons
        for (int i = 0; i < 10; i++) {
            frame.add(numberButtons[i]);
        }
        frame.add(cancelButton);
        frame.add(clearButton);
        frame.add(enterButton);

        frame.add(panel);   // Add the panel to the frame

        frame.add(atm);   // Add the ATM label to the frame

        frame.setVisible(true);


        createLabelsAndTextField();

        // Start of the program
        // 1 = Sign up
        // 2 = Sign in
        // buttons 0 and 3-9 are disabled
        start();
    }

    void start() {
        currentPage = "Start";
        panel.removeAll(); // Clear the panel

        // disable number buttons except for 1 and 2
        disableNumberButtons();
        numberButtons[1].setEnabled(true);
        numberButtons[2].setEnabled(true);
        cancelButton.setEnabled(false);
        clearButton.setEnabled(false);
        enterButton.setEnabled(false);

        // Labels

        JLabel signUpLabel = new JLabel();
        signUpLabel.setText("1 = SIGN UP");
        signUpLabel.setForeground(Color.gray);
        signUpLabel.setFont(new Font("Arial",Font.BOLD,40));
        signUpLabel.setBounds(190, -160, 500, 500);

        JLabel logInLabel = new JLabel();
        logInLabel.setText("2 = LOG IN");
        logInLabel.setForeground(Color.gray);
        logInLabel.setFont(new Font("Arial",Font.BOLD,40));
        logInLabel.setBounds(190, -100, 500, 500);

        panel.add(signUpLabel);
        panel.add(logInLabel);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void createLabelsAndTextField() {
        // First text field for numbers and second is for showing letters

        firstTextField = new JTextField();
        firstTextField.setForeground(Color.white);
        firstTextField.setBackground(new Color(70, 100, 0));
        firstTextField.setBounds(130, 70, 330, 30);
        firstTextField.setFont(new Font("Arial", Font.PLAIN,20));
        firstTextField.setEditable(false);
        firstTextField.setText("");

        secondTextField = new JTextField();
        secondTextField.setBounds(130, 120, 330, 30);
        secondTextField.setForeground(Color.white);
        secondTextField.setBackground(new Color(60, 80, 0));
        secondTextField.setFont(new Font("Arial", Font.PLAIN,20));
        secondTextField.setEditable(false);
        secondTextField.setText("");

        // Letters labels

        firstRowLetters = new JLabel();
        firstRowLetters.setText("A = 1     B = 2      C = 3      D = 4      E = 5      F = 6      G = 7      H = 8      I = 9");
        firstRowLetters.setForeground(Color.gray);
        firstRowLetters.setFont(new Font("Arial", Font.BOLD, 10));
        firstRowLetters.setBounds(120, -80, 500, 500);

        secondRowLetters = new JLabel();
        secondRowLetters.setText("J = 10    K = 11    L = 12    M = 13    N = 14    O = 15    P = 16    Q = 17    R = 18");
        secondRowLetters.setForeground(Color.gray);
        secondRowLetters.setFont(new Font("Arial", Font.BOLD, 10));
        secondRowLetters.setBounds(120, -60, 500, 500);

        thirdRowLetters = new JLabel();
        thirdRowLetters.setText("S = 19    T = 20    U = 21    V = 22    W = 23    X = 24    Y = 25    Z = 26");
        thirdRowLetters.setForeground(Color.gray);
        thirdRowLetters.setFont(new Font("Arial", Font.BOLD, 10));
        thirdRowLetters.setBounds(120, -40, 500, 500);

    }

    void signUpUsername() {
        currentPage = "SignUpUsername";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");
        secondTextField.setText("");

        // Create the SIGN-UP username page

        // Label
        JLabel usernameLabel = new JLabel();
        usernameLabel.setText("CREATE USERNAME");
        usernameLabel.setForeground(Color.gray);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 25));
        usernameLabel.setBounds(160, -210, 1000, 500);

        // ENABLE BUTTONS
        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        // Add changes to the panel
        panel.add(usernameLabel);
        panel.add(firstRowLetters);
        panel.add(secondRowLetters);
        panel.add(thirdRowLetters);

        // set places of textFields
        firstTextField.setBounds(130, 70, 330, 30);
        secondTextField.setBounds(130, 120, 330, 30);

        panel.add(firstTextField);
        panel.add(secondTextField);

        panel.setLayout(null);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void signUpPin() {
        currentPage = "SignUpPin";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");

        // Create the SIGN-UP pin page

        // Labels
        JLabel fourDigitsPin = new JLabel();
        fourDigitsPin.setText("4 DIGITS PIN");
        fourDigitsPin.setForeground(Color.gray);
        fourDigitsPin.setFont(new Font("Arial",Font.BOLD,40));
        fourDigitsPin.setBounds(170, -190, 500, 500);

        JLabel or = new JLabel();
        or.setText("OR");
        or.setForeground(Color.gray);
        or.setFont(new Font("Arial",Font.BOLD,40));
        or.setBounds(260, -130, 500, 500);

        JLabel sixDigitsPin = new JLabel();
        sixDigitsPin.setText("6 DIGITS PIN");
        sixDigitsPin.setForeground(Color.gray);
        sixDigitsPin.setFont(new Font("Arial",Font.BOLD,40));
        sixDigitsPin.setBounds(170, -70, 500, 500);

        // ENABLE ON 4, 6, AND CANCEL BUTTON
        disableNumberButtons();
        clearButton.setEnabled(false);
        enterButton.setEnabled(false);
        numberButtons[4].setEnabled(true);
        numberButtons[6].setEnabled(true);

        // add changes to the panel
        panel.add(fourDigitsPin);
        panel.add(or);
        panel.add(sixDigitsPin);

        panel.setLayout(null);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void showSignUpDetails(String signUpName, StringBuilder signUpPin) {
        currentPage = "ShowSignUpDetails";
        panel.removeAll(); // Clear the panel

        // ENABLE ONLY ENTER AND CANCEL BUTTON
        disableNumberButtons();
        cancelButton.setEnabled(true);
        enterButton.setEnabled(true);

        // Labels
        JLabel usernameLabel = new JLabel();
        usernameLabel.setText("USERNAME:      " + signUpName);
        usernameLabel.setForeground(Color.gray);
        usernameLabel.setFont(new Font("Arial",Font.BOLD,30));
        usernameLabel.setBounds(115, -130, 1000, 500);

        JLabel pinLabel = new JLabel();
        pinLabel.setText("PIN:                    " + signUpPin);
        pinLabel.setForeground(Color.gray);
        pinLabel.setFont(new Font("Arial",Font.BOLD,30));
        pinLabel.setBounds(115, -80, 1000, 500);

        panel.add(usernameLabel);
        panel.add(pinLabel);


        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void enterUsername() {
        currentPage = "EnterUsername";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");
        secondTextField.setText("");

        // Enable all buttons
        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        // Label
        JLabel logInUsernameLabel = new JLabel();
        logInUsernameLabel.setText("USERNAME");
        logInUsernameLabel.setForeground(Color.gray);
        logInUsernameLabel.setFont(new Font("Arial",Font.BOLD,25));
        logInUsernameLabel.setBounds(225, -210, 1000, 500);

        // Add changes to the panel
        panel.add(logInUsernameLabel);
        panel.add(firstRowLetters);
        panel.add(secondRowLetters);
        panel.add(thirdRowLetters);

        // set places of textFields
        firstTextField.setBounds(130, 70, 330, 30);
        secondTextField.setBounds(130, 120, 330, 30);

        panel.add(firstTextField);
        panel.add(secondTextField);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void enterPin() {
        currentPage = "EnterPin";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");

        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel enterPinLabel = new JLabel();
        enterPinLabel.setText("PIN");
        enterPinLabel.setForeground(Color.gray);
        enterPinLabel.setFont(new Font("Arial",Font.BOLD,30));
        enterPinLabel.setBounds(270, -150, 1000, 500);

        firstTextField.setBounds(130, 120, 330, 30);

        panel.add(enterPinLabel);
        panel.add(firstTextField);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void showAtmFunctions() {
        currentPage = "ShowAtmFunctions";
        panel.removeAll(); // Clear the panel

        // number 1-7 buttons only needed
        enableNumberButtons();
        numberButtons[8].setEnabled(false);
        numberButtons[9].setEnabled(false);
        numberButtons[0].setEnabled(false);
        cancelButton.setEnabled(false);
        clearButton.setEnabled(false);
        enterButton.setEnabled(false);


        JLabel depositLabel = new JLabel();
        depositLabel.setText("1 = DEPOSIT");
        depositLabel.setForeground(Color.gray);
        depositLabel.setFont(new Font("Arial",Font.BOLD,20));
        depositLabel.setBounds(190, -215, 1000, 500);

        JLabel withdrawLabel = new JLabel();
        withdrawLabel.setText("2 = WITHDRAW");
        withdrawLabel.setForeground(Color.gray);
        withdrawLabel.setFont(new Font("Arial",Font.BOLD,20));
        withdrawLabel.setBounds(190, -185, 1000, 500);

        JLabel checkBalanceLabel = new JLabel();
        checkBalanceLabel.setText("3 = CHECK BALANCE");
        checkBalanceLabel.setForeground(Color.gray);
        checkBalanceLabel.setFont(new Font("Arial",Font.BOLD,20));
        checkBalanceLabel.setBounds(190, -155, 1000, 500);

        JLabel transferFundsLabel = new JLabel();
        transferFundsLabel.setText("4 = TRANSFER FUNDS");
        transferFundsLabel.setForeground(Color.gray);
        transferFundsLabel.setFont(new Font("Arial",Font.BOLD,20));
        transferFundsLabel.setBounds(190, -125, 1000, 500);

        JLabel changeNameLabel = new JLabel();
        changeNameLabel.setText("5 = CHANGE NAME");
        changeNameLabel.setForeground(Color.gray);
        changeNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        changeNameLabel.setBounds(190, -95, 1000, 500);

        JLabel changePinLabel = new JLabel();
        changePinLabel.setText("6 = CHANGE PIN");
        changePinLabel.setForeground(Color.gray);
        changePinLabel.setFont(new Font("Arial",Font.BOLD,20));
        changePinLabel.setBounds(190, -65, 1000, 500);

        JLabel signOutLabel = new JLabel();
        signOutLabel.setText("7 = SIGN OUT");
        signOutLabel.setForeground(Color.gray);
        signOutLabel.setFont(new Font("Arial",Font.BOLD,20));
        signOutLabel.setBounds(190, -35, 1000, 500);


        panel.add(depositLabel);
        panel.add(withdrawLabel);
        panel.add(checkBalanceLabel);
        panel.add(transferFundsLabel);
        panel.add(changeNameLabel);
        panel.add(changePinLabel);
        panel.add(signOutLabel);


        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void depositPage() {
        currentPage = "Deposit";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");

        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel depositLabel = new JLabel();
        depositLabel.setText("DEPOSIT");
        depositLabel.setForeground(Color.gray);
        depositLabel.setFont(new Font("Arial",Font.BOLD,30));
        depositLabel.setBounds(230, -150, 1000, 500);

        firstTextField.setBounds(130, 120, 330, 30);

        panel.add(depositLabel);
        panel.add(firstTextField);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void withdrawPage() {
        currentPage = "Withdraw";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");

        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setText("BALANCE: " + accounts.get(username).getBalance());
        balanceLabel.setForeground(Color.gray);
        balanceLabel.setFont(new Font("Arial",Font.BOLD,30));
        balanceLabel.setBounds(20, -220, 1000, 500);

        JLabel withdrawLabel = new JLabel();
        withdrawLabel.setText("WITHDRAW");
        withdrawLabel.setForeground(Color.gray);
        withdrawLabel.setFont(new Font("Arial",Font.BOLD,30));
        withdrawLabel.setBounds(210, -150, 1000, 500);

        firstTextField.setBounds(130, 120, 330, 30);

        panel.add(balanceLabel);
        panel.add(withdrawLabel);
        panel.add(firstTextField);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void balancePage() {
        currentPage = "Balance";
        panel.removeAll(); // Clear the panel

        // Enter button is only needed
        disableNumberButtons();
        cancelButton.setEnabled(false);
        clearButton.setEnabled(false);
        enterButton.setEnabled(true);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setText("BALANCE: " + accounts.get(username).getBalance());
        balanceLabel.setForeground(Color.gray);
        balanceLabel.setFont(new Font("Arial",Font.BOLD,30));
        balanceLabel.setBounds(20, -220, 1000, 500);


        panel.add(balanceLabel);
        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void transferFundsToPage() {
        currentPage = "TransferFundsTo";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");
        secondTextField.setText("");

        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel transferFundsToLabel = new JLabel();
        transferFundsToLabel.setText("TRANSFER FUNDS TO");
        transferFundsToLabel.setForeground(Color.gray);
        transferFundsToLabel.setFont(new Font("Arial",Font.BOLD,30));
        transferFundsToLabel.setBounds(130, -210, 1000, 500);

        panel.add(transferFundsToLabel);
        panel.add(firstRowLetters);
        panel.add(secondRowLetters);
        panel.add(thirdRowLetters);

        // set places of textFields
        firstTextField.setBounds(130, 70, 330, 30);
        secondTextField.setBounds(130, 120, 330, 30);

        panel.add(firstTextField);
        panel.add(secondTextField);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }
    void transferAmountPage() {
        currentPage = "TransferAmount";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");

        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel transferAmountLabel = new JLabel();
        transferAmountLabel.setText("TRANSFER AMOUNT");
        transferAmountLabel.setForeground(Color.gray);
        transferAmountLabel.setFont(new Font("Arial",Font.BOLD,30));
        transferAmountLabel.setBounds(140, -150, 1000, 500);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setText("BALANCE: " + accounts.get(username).getBalance());
        balanceLabel.setForeground(Color.gray);
        balanceLabel.setFont(new Font("Arial",Font.BOLD,30));
        balanceLabel.setBounds(20, -220, 1000, 500);


        firstTextField.setBounds(130, 120, 330, 30);

        panel.add(transferAmountLabel);
        panel.add(balanceLabel);
        panel.add(firstTextField);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }


    void changeNamePage() {
        currentPage = "ChangeName";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");

        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel enterPinLabel = new JLabel();
        enterPinLabel.setText("PIN");
        enterPinLabel.setForeground(Color.gray);
        enterPinLabel.setFont(new Font("Arial",Font.BOLD,30));
        enterPinLabel.setBounds(260, -150, 1000, 500);

        firstTextField.setBounds(130, 120, 330, 30);

        panel.add(enterPinLabel);
        panel.add(firstTextField);


        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void newNamePage() {
        currentPage = "NewName";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");
        secondTextField.setText("");

        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel newUsernameLabel = new JLabel();
        newUsernameLabel.setText("NEW USERNAME");
        newUsernameLabel.setForeground(Color.gray);
        newUsernameLabel .setFont(new Font("Arial",Font.BOLD,30));
        newUsernameLabel.setBounds(170, -210, 1000, 500);

        panel.add(newUsernameLabel);
        panel.add(firstRowLetters);
        panel.add(secondRowLetters);
        panel.add(thirdRowLetters);

        // set places of textFields
        firstTextField.setBounds(130, 70, 330, 30);
        secondTextField.setBounds(130, 120, 330, 30);

        panel.add(firstTextField);
        panel.add(secondTextField);



        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void changePinPage() {
        currentPage = "ChangePin";
        panel.removeAll(); // Clear the panel

        // Clear textFields
        firstTextField.setText("");

        enableNumberButtons();
        cancelButton.setEnabled(true);
        clearButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel enterPinLabel = new JLabel();
        enterPinLabel.setText("OLD PIN");
        enterPinLabel.setForeground(Color.gray);
        enterPinLabel.setFont(new Font("Arial",Font.BOLD,30));
        enterPinLabel.setBounds(240, -150, 1000, 500);

        firstTextField.setBounds(130, 120, 330, 30);

        panel.add(enterPinLabel);
        panel.add(firstTextField);


        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }

    void newPinPage() {
        currentPage = "NewPin";
        panel.removeAll(); // Clear the panel

        JLabel fourDigitsPin = new JLabel();
        fourDigitsPin.setText("4 DIGITS PIN");
        fourDigitsPin.setForeground(Color.gray);
        fourDigitsPin.setFont(new Font("Arial",Font.BOLD,40));
        fourDigitsPin.setBounds(170, -190, 500, 500);

        JLabel or = new JLabel();
        or.setText("OR");
        or.setForeground(Color.gray);
        or.setFont(new Font("Arial",Font.BOLD,40));
        or.setBounds(260, -130, 500, 500);

        JLabel sixDigitsPin = new JLabel();
        sixDigitsPin.setText("6 DIGITS PIN");
        sixDigitsPin.setForeground(Color.gray);
        sixDigitsPin.setFont(new Font("Arial",Font.BOLD,40));
        sixDigitsPin.setBounds(170, -70, 500, 500);

        // ENABLE ON 4, 6, AND CANCEL BUTTON
        disableNumberButtons();
        clearButton.setEnabled(false);
        enterButton.setEnabled(false);
        numberButtons[4].setEnabled(true);
        numberButtons[6].setEnabled(true);

        panel.add(fourDigitsPin);
        panel.add(or);
        panel.add(sixDigitsPin);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }
    void showNewPin() {
        currentPage = "ShowNewPin";
        panel.removeAll();

        // ENABLE ONLY ENTER AND CANCEL BUTTON
        disableNumberButtons();
        cancelButton.setEnabled(true);
        enterButton.setEnabled(true);

        JLabel pinLabel = new JLabel();
        pinLabel.setText("PIN:" + tempPin);
        pinLabel.setForeground(Color.gray);
        pinLabel.setFont(new Font("Arial",Font.BOLD,40));
        pinLabel.setBounds(200, -130, 1000, 500);

        panel.add(pinLabel);

        // Changes must be revalidate and repaint
        panel.revalidate();
        panel.repaint();

        frame.setVisible(true);
    }


    // DISABLE NUMBER BUTTONS
    void disableNumberButtons() {
        for (int i = 0; i < 10; i++) {
            numberButtons[i].setEnabled(false);
        }
    }

    // ENABLE NUMBER BUTTONS
    void enableNumberButtons() {
        for (int i = 0; i < 10; i++) {
            numberButtons[i].setEnabled(true);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Start Page buttons
        if (currentPage.equals("Start")) {
            if (e.getSource() == numberButtons[1]) {
                signUpUsername();
            } else if (e.getSource() == numberButtons[2]) {
                enterUsername();
            }
        }

        // Buttons ActionListeners for text fields
        // shows the value of the button being click on the textfield
        else if (e.getSource() == numberButtons[1]) {
            firstTextField.setText(firstTextField.getText() + 1);
        } else if (e.getSource() == numberButtons[2]) {
            firstTextField.setText(firstTextField.getText() + 2);
        } else if (e.getSource() == numberButtons[3]) {
            firstTextField.setText(firstTextField.getText() + 3);
        } else if (e.getSource() == numberButtons[4]) {
            firstTextField.setText(firstTextField.getText() + 4);
        } else if (e.getSource() == numberButtons[5]) {
            firstTextField.setText(firstTextField.getText() + 5);
        } else if (e.getSource() == numberButtons[6]) {
            firstTextField.setText(firstTextField.getText() + 6);
        } else if (e.getSource() == numberButtons[7]) {
            firstTextField.setText(firstTextField.getText() + 7);
        } else if (e.getSource() == numberButtons[8]) {
            firstTextField.setText(firstTextField.getText() + 8);
        } else if (e.getSource() == numberButtons[9]) {
            firstTextField.setText(firstTextField.getText() + 9);
        } else if (e.getSource() == numberButtons[0]) {
            firstTextField.setText(firstTextField.getText() + 0);
        }


        // Clear Buttons action listener in first text field
        if (e.getSource() == clearButton) {
            firstTextField.setText("");
            for (int i = 0; i < 10; i++) {
                numberButtons[i].setEnabled(true);
            }
            enterButton.setEnabled(true);
        }

        // SIGN UP USERNAME PAGE
        if (currentPage.equals("SignUpUsername")) {
            // Cancel Buttons action listener in SIGN UP AND SIGN IN USERNAME page
            if (e.getSource() == cancelButton) {
                start();
            }

            // Enter Buttons action listener in SIGN UP USERNAME page
            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("") && secondTextField.getText().equals("")) {
                    firstTextField.setText("NO INPUT");
                    clearTextField();
                } else if (firstTextField.getText().equals("")) {
                    if (accounts.containsKey(secondTextField.getText())) {
                        firstTextField.setText("ACCOUNT NAME ALREADY TAKEN");
                        clearTextField();
                        secondTextField.setText("");
                    } else {
                        tempUsername = secondTextField.getText();
                        signUpPin();
                    }
                } else if (Integer.parseInt(firstTextField.getText()) > 26 || (Integer.parseInt(firstTextField.getText())) == 0) {
                    firstTextField.setText("INVALID INPUT");
                    clearTextField();
                } else {
                    // Converts 1 = A, 2 = B, ..... 26 = Z\
                    secondTextField.setText(secondTextField.getText().concat
                            (String.valueOf((char) (Integer.parseInt(firstTextField.getText()) + 64))));
                    // Convert ASCII code to char value

                    firstTextField.setText("");
                }
            }
        }

        // SIGN UP PIN PAGE
        if (currentPage.equals("SignUpPin")) {
            // Cancel Button action listener on SIGN UP PIN page
            if (e.getSource() == cancelButton) {
                signUpUsername();
            }

            // 4 DIGIT PIN CREATION
            if (e.getSource() == numberButtons[4]) {
                tempPin = createPin(4);
                showSignUpDetails(tempUsername, tempPin);
            }

            // 6 DIGIT PIN CREATION
            if (e.getSource() == numberButtons[6]) {
                tempPin = createPin(6);
                showSignUpDetails(tempUsername, tempPin);
            }
        }

        // SHOW SIGN UP DETAILS PAGE
        if (currentPage.equals("ShowSignUpDetails")) {
            // when cancel button is pressed in the sign up details, it means that the sign up is cancelled and will go back to the sign up pin page
            if (e.getSource() == cancelButton) {
                signUpPin();
            }

            // When enter button is pressed in the sign up details, it means that the details are confirmed and the account will be created
            if (e.getSource() == enterButton) {
               createAccount(tempPin, tempUsername);
               start();
            }
        }

        // ENTER USERNAME PAGE
        if (currentPage.equals("EnterUsername")) {
            // Go back to start page when cancel button is pressed when entering username
            if (e.getSource() == cancelButton) {
                start();
            }

            // Enter Buttons action listener in SIGN IN USERNAME page
            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("") && secondTextField.getText().equals("")) {
                    firstTextField.setText("NO INPUT");
                    clearTextField();
                }  else if (firstTextField.getText().equals("")) {
                    if (!accounts.containsKey(secondTextField.getText())) {
                        firstTextField.setText("ACCOUNT INVALID");
                        clearTextField();
                        secondTextField.setText("");
                    } else {
                        username = secondTextField.getText();
                        enterPin();
                    }
                } else if (Integer.parseInt(firstTextField.getText()) > 26 || (Integer.parseInt(firstTextField.getText())) == 0) {
                    firstTextField.setText("INVALID INPUT");
                    clearTextField();
                } else {
                    // Converts 1 = A, 2 = B, ..... 26 = Z\
                    secondTextField.setText(secondTextField.getText().concat
                            (String.valueOf((char) (Integer.parseInt(firstTextField.getText()) + 64))));
                    // Convert ASCII code to char value
                    firstTextField.setText("");
                }
            }
        }

        // ENTER PIN PAGE
        else if (currentPage.equals("EnterPin")) {
            // Go back to enterUsername when the cancel button is pressed when entering pin
            if (e.getSource() == cancelButton) {
                enterUsername();
            }

            // Enter Buttons action listener in ENTER PIN page
            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("")) {
                    firstTextField.setText("INPUT PIN");
                    clearTextField();
                } else if (accounts.get(username).getPin().equals(firstTextField.getText())) {
                    showAtmFunctions();

                } else {
                    firstTextField.setText("INVALID PIN");
                    clearTextField();
                }
            }
        }

        // SHOW ATM FUNCTIONS PAGE
        if (currentPage.equals("ShowAtmFunctions")) {
            if (e.getSource() == numberButtons[1]) {
                depositPage();
            } else if (e.getSource() == numberButtons[2]) {
                withdrawPage();
            } else if (e.getSource() == numberButtons[3]) {
                balancePage();
            } else if (e.getSource() == numberButtons[4]) {
                transferFundsToPage();
            } else if (e.getSource() == numberButtons[5]) {
                changeNamePage();
            } else if (e.getSource() == numberButtons[6]) {
                changePinPage();
            } else if (e.getSource() == numberButtons[7]) {
                start();
            }
        }


        // DEPOSIT PAGE
        if (currentPage.equals("Deposit")) {
            if (e.getSource() == cancelButton) {
                showAtmFunctions();
            }

            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("")) {
                    firstTextField.setText("INPUT VALUE");
                    clearTextField();
                } else if (Integer.parseInt(firstTextField.getText()) == 0) {
                    firstTextField.setText("ENTER VALID AMOUNT");
                    clearTextField();
                } else {
                    accounts.get(username).deposit(Integer.parseInt(firstTextField.getText()));
                    showAtmFunctions();
                }
            }
        }

        // WITHDRAW PAGE
        if (currentPage.equals("Withdraw")) {
            if (e.getSource() == cancelButton) {
                showAtmFunctions();
            }

            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("")) {
                    firstTextField.setText("INPUT VALUE");
                    clearTextField();
                } else if (Integer.parseInt(firstTextField.getText()) > BALANCE_WITHDRAW_LIMIT) {
                    firstTextField.setText("LIMIT = 50000");
                    clearTextField();
                } else if (Integer.parseInt(firstTextField.getText()) > accounts.get(username).getBalance()) {
                    firstTextField.setText("AMOUNT > BALANCE");
                    clearTextField();
                } else if (Integer.parseInt(firstTextField.getText()) == 0) {
                    firstTextField.setText("ENTER VALID AMOUNT");
                    clearTextField();
                } else {
                    accounts.get(username).withdraw(Integer.parseInt(firstTextField.getText()));
                    showAtmFunctions();
                }
            }
        }

        // BALANCE PAGE
        if (currentPage.equals("Balance")) {
            if (e.getSource() == enterButton ) {
                showAtmFunctions();
            }
        }

        // TRANSFER FUNDS TO PAGE
        if (currentPage.equals("TransferFundsTo")) {
            if (e.getSource() == cancelButton) {
                showAtmFunctions();
            }

            // Enter Buttons action listener in TRANSFER FUNDS page
            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("") && secondTextField.getText().equals("")) {
                    firstTextField.setText("NO INPUT");
                    clearTextField();
                }  else if (firstTextField.getText().equals("")) {
                    if (!accounts.containsKey(secondTextField.getText())) {
                        firstTextField.setText("ACCOUNT INVALID");
                        clearTextField();
                        secondTextField.setText("");
                    } else {
                        receiver = secondTextField.getText();
                        transferAmountPage();
                    }
                } else if (Integer.parseInt(firstTextField.getText()) > 26 || (Integer.parseInt(firstTextField.getText())) == 0) {
                    firstTextField.setText("INVALID INPUT");
                    clearTextField();
                } else {
                    // Converts 1 = A, 2 = B, ..... 26 = Z\
                    secondTextField.setText(secondTextField.getText().concat
                            (String.valueOf((char) (Integer.parseInt(firstTextField.getText()) + 64))));
                    // Convert ASCII code to char value

                    firstTextField.setText("");
                }
            }
        }

        // TRANSFER FUNDS AMOUNT PAGE
        else if (currentPage.equals("TransferAmount")) {
            if (e.getSource() == cancelButton) {
                transferFundsToPage();
            }

            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("")) {
                    firstTextField.setText("NO INPUT");
                    clearTextField();
                } else if (Integer.parseInt(firstTextField.getText()) > accounts.get(username).getBalance()) {
                    firstTextField.setText("AMOUNT > BALANCE");
                    clearTextField();
                } else if (Integer.parseInt(firstTextField.getText()) == 0) {
                    firstTextField.setText("ENTER VALID AMOUNT");
                    clearTextField();
                } else {
                    transferAmount = Integer.parseInt(firstTextField.getText());
                    accounts.get(username).transferFunds(receiver, transferAmount);
                    showAtmFunctions();
                }
            }
        }

        // CHANGE NAME PAGE
        else if (currentPage.equals("ChangeName")) {
            // Go back to showAtmFunction when the cancel button
            if (e.getSource() == cancelButton) {
                showAtmFunctions();
            }

            // Enter Buttons action listener in ENTER PIN page
            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("")) {
                    firstTextField.setText("INPUT PIN");
                    clearTextField();
                } else if (accounts.get(username).getPin().equals(firstTextField.getText())) {
                    newNamePage();
                } else {
                    firstTextField.setText("INVALID PIN");
                    clearTextField();
                }
            }
        }

        // NEW NAME PAGE
        else if (currentPage.equals("NewName")) {
            if (e.getSource() == cancelButton) {
                showAtmFunctions();
            }

            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("") && secondTextField.getText().equals("")) {
                    firstTextField.setText("NO INPUT");
                    clearTextField();
                }  else if (firstTextField.getText().equals("")) {
                    if (accounts.containsKey(secondTextField.getText())) {
                        firstTextField.setText("USERNAME ALREADY TAKEN");
                        clearTextField();
                        secondTextField.setText("");
                    } else {
                        String newUsername = secondTextField.getText();
                        accounts.get(username).changeName(username, newUsername);
                        username  = newUsername;
                        start();
                    }
                } else if (Integer.parseInt(firstTextField.getText()) > 26 || (Integer.parseInt(firstTextField.getText())) == 0) {
                    firstTextField.setText("INVALID INPUT");
                    clearTextField();
                } else {
                    // Converts 1 = A, 2 = B, ..... 26 = Z\
                    secondTextField.setText(secondTextField.getText().concat
                            (String.valueOf((char) (Integer.parseInt(firstTextField.getText()) + 64))));
                    // Convert ASCII code to char value

                    firstTextField.setText("");
                }
            }
        }

        // CHANGE PIN PAGE
        if (currentPage.equals("ChangePin")) {
            // Go back to showAtmFunction when the cancel button
            if (e.getSource() == cancelButton) {
                showAtmFunctions();
            }

            // Enter Buttons action listener in ENTER PIN page
            if (e.getSource() == enterButton) {
                if (firstTextField.getText().equals("")) {
                    firstTextField.setText("INPUT PIN");
                    clearTextField();
                } else if (accounts.get(username).getPin().equals(firstTextField.getText())) {
                    newPinPage();
                } else {
                    firstTextField.setText("INVALID PIN");
                    clearTextField();
                }
            }
        }

        // NEW PIN PAGE
        if (currentPage.equals("NewPin")) {
            if (e.getSource() == cancelButton) {
                showAtmFunctions();
            }

            // 4 DIGIT PIN CREATION
            if (e.getSource() == numberButtons[4]) {
                tempPin = createPin(4);
                showNewPin();
            }

            // 6 DIGIT PIN CREATION
            if (e.getSource() == numberButtons[6]) {
                tempPin = createPin(6);
                showNewPin();
            }
        }

        // SHOW NEW PIN PAGE
        if (currentPage.equals("ShowNewPin")) {
            if (e.getSource() == cancelButton) {
                newPinPage();
            }

            if (e.getSource() == enterButton) {
                accounts.get(username).changePin(tempPin);
                start();
            }
        }

    }



    // Disable all buttons except for clear
    // This is for clearing informations on textfields
    void clearTextField() {
        // Disable all numbers and the enter button, until the String is cleared
        for (int i = 0; i < 10; i++) {
            numberButtons[i].setEnabled(false);
        }
        enterButton.setEnabled(false);
    }

    void createButtons() {
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton();
            numberButtons[i].addActionListener(this);
        }
        cancelButton.addActionListener(this);
        clearButton.addActionListener(this);
        enterButton.addActionListener(this);

        numberButtons[1].setText("1");
        numberButtons[1].setFocusable(false); // removes a line that focus on the text
        numberButtons[1].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[1].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[1].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[1].setForeground(Color.black);    // Set the color of the text
        numberButtons[1].setBackground(Color.GRAY);
        numberButtons[1].setBounds(220, 335, 65, 65); // Position(x position, y position, width, height)

        numberButtons[2].setText("2");
        numberButtons[2].setFocusable(false); // removes a line that focus on the text
        numberButtons[2].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[2].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[2].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[2].setForeground(Color.black);    // Set the color of the text
        numberButtons[2].setBackground(Color.GRAY);
        numberButtons[2].setBounds(295, 335, 65, 65); // Position(x position, y position, width, height)

        numberButtons[3].setText("3");
        numberButtons[3].setFocusable(false); // removes a line that focus on the text
        numberButtons[3].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[3].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[3].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[3].setForeground(Color.black);    // Set the color of the text
        numberButtons[3].setBackground(Color.GRAY);
        numberButtons[3].setBounds(370, 335, 65, 65); // Position(x position, y position, width, height)

        cancelButton.setText("Cancel");
        cancelButton.setFocusable(false); // removes a line that focus on the text
        cancelButton.setHorizontalTextPosition(JButton.CENTER);
        cancelButton.setVerticalTextPosition(JButton.BOTTOM);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 20));
        cancelButton.setForeground(Color.black);    // Set the color of the text
        cancelButton.setBackground(new Color(140, 0, 0));
        cancelButton.setBounds(445, 335, 130, 65); // Position(x position, y position, width, height)

        numberButtons[4].setText("4");
        numberButtons[4].setFocusable(false); // removes a line that focus on the text
        numberButtons[4].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[4].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[4].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[4].setForeground(Color.black);    // Set the color of the text
        numberButtons[4].setBackground(Color.GRAY);
        numberButtons[4].setBounds(220, 410, 65, 65); // Position(x position, y position, width, height)

        numberButtons[5].setText("5");
        numberButtons[5].setFocusable(false); // removes a line that focus on the text
        numberButtons[5].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[5].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[5].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[5].setForeground(Color.black);    // Set the color of the text
        numberButtons[5].setBackground(Color.GRAY);
        numberButtons[5].setBounds(295, 410, 65, 65); // Position(x position, y position, width, height)

        numberButtons[6].setText("6");
        numberButtons[6].setFocusable(false); // removes a line that focus on the text
        numberButtons[6].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[6].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[6].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[6].setForeground(Color.black);    // Set the color of the text
        numberButtons[6].setBackground(Color.GRAY);
        numberButtons[6].setBounds(370, 410, 65, 65); // Position(x position, y position, width, height)

        clearButton.setText("Clear");
        clearButton.setFocusable(false); // removes a line that focus on the text
        clearButton.setHorizontalTextPosition(JButton.CENTER);
        clearButton.setVerticalTextPosition(JButton.BOTTOM);
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setForeground(Color.black);    // Set the color of the text
        clearButton.setBackground(new Color(160, 160, 0));
        clearButton.setBounds(445, 410, 130, 65); // Position(x position, y position, width, height)

        numberButtons[7].setText("7");
        numberButtons[7].setFocusable(false); // removes a line that focus on the text
        numberButtons[7].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[7].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[7].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[7].setForeground(Color.black);    // Set the color of the text
        numberButtons[7].setBackground(Color.GRAY);
        numberButtons[7].setBounds(220, 485, 65, 65); // Position(x position, y position, width, height)

        numberButtons[8].setText("8");
        numberButtons[8].setFocusable(false); // removes a line that focus on the text
        numberButtons[8].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[8].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[8].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[8].setForeground(Color.black);    // Set the color of the text
        numberButtons[8].setBackground(Color.GRAY);
        numberButtons[8].setBounds(295, 485, 65, 65); // Position(x position, y position, width, height)

        numberButtons[9].setText("9");
        numberButtons[9].setFocusable(false); // removes a line that focus on the text
        numberButtons[9].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[9].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[9].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[9].setForeground(Color.black);    // Set the color of the text
        numberButtons[9].setBackground(Color.GRAY);
        numberButtons[9].setBounds(370, 485, 65, 65); // Position(x position, y position, width, height)

        enterButton.setText("Enter");
        enterButton.setFocusable(false); // removes a line that focus on the text
        enterButton.setHorizontalTextPosition(JButton.CENTER);
        enterButton.setVerticalTextPosition(JButton.BOTTOM);
        enterButton.setFont(new Font("Arial", Font.BOLD, 20));
        enterButton.setForeground(Color.black);    // Set the color of the text
        enterButton.setBackground(new Color(40, 100, 0));
        enterButton.setBounds(445, 485, 130, 65); // Position(x position, y position, width, height)

        numberButtons[0].setText("0");
        numberButtons[0].setFocusable(false); // removes a line that focus on the text
        numberButtons[0].setHorizontalTextPosition(JButton.CENTER);
        numberButtons[0].setVerticalTextPosition(JButton.BOTTOM);
        numberButtons[0].setFont(new Font("Arial", Font.PLAIN, 20));
        numberButtons[0].setForeground(Color.black);    // Set the color of the text
        numberButtons[0].setBackground(Color.GRAY);
        numberButtons[0].setBounds(295, 560, 65, 65); // Position(x position, y position, width, height)
    }

    public static void main(String[] args) {
        new ATMGUI();
    }

}
