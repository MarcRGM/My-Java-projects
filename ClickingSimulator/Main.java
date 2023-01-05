package MyPrograms.ClickingSimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
	JButton button1, button2;
	private int addCoin = 1;
	private int addEnergy = 5;
	private int coins = 0;
	private int range = 100;
	private int energyPrice = 3;
	private int energy = 5;
	private int coinUpgradeCost = 5;
	private int energyUpgradeCost = 8;
	
	public Main()
	{

		// ========================= Coin Generator Button ===================================

		button1 = new JButton();
		button1.setBounds(0, 0, 235, 150);
		button1.addActionListener(this);
		button1.setText("C");
		button1.setForeground(new Color(255, 201, 166));
		button1.setFocusable(false);
		button1.setHorizontalTextPosition(JButton.CENTER);
		button1.setVerticalTextPosition(JButton.BOTTOM);
		button1.setFont(new Font("Roboto", Font.BOLD, 15));
		button1.setIconTextGap(0);
		button1.setBackground(new Color(184, 120, 72));
		button1.setBorder(BorderFactory.createEtchedBorder());
		button1.setEnabled(true);
		
		// ========================= Shop Button ===================================
		
		button2 = new JButton();
		button2.setBounds(0, 150, 235, 62);
		button2.addActionListener(this);
		button2.setText("S");
		button2.setForeground(new Color(178, 243, 149, 255));
		button2.setFocusable(false);
		button2.setBackground(new Color(78, 117, 70));
		button2.setBorder(BorderFactory.createEtchedBorder());
		button2.setEnabled(true);

		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(250, 250);
		this.setResizable(false);
		this.setVisible(true);
		this.add(button1);
		this.add(button2);
		

		System.out.println("Welcome to coin generator!");
		System.out.println("You have " + energy + " energy");
		System.out.println("You can increase your balance by clicking the c button, however, each time "
				+ "you use that button, your energy will decrease by 1");
		System.out.println("Enter the shop by clicking the s button and check things you can buy with your balance");
		System.out.println("you will win this game if you reach up to 1000 coins, good luck!");
		
	}

	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == button1)
		{
			energy--;
			coins += addCoin;
			
			System.out.println("Balance: " + coins);
			System.out.println("Energy: " + energy);
			
			if (energy == 0)
			{
				button1.setEnabled(false);
				System.out.println("Balance: " + coins);
				JOptionPane.showMessageDialog(null,"You ran out of energy, energy cost "+ energyPrice +"c",
						"Alert", JOptionPane.WARNING_MESSAGE);
				int buy = JOptionPane.showConfirmDialog(null,"Want to buy more energy?, remember that the cost of energy " +
						"increases when you reach to a certain balance");
				if (buy == JOptionPane.YES_OPTION)
				{
					buyEnergy();
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Bye bye!");
					return;
				}
			}
		}
		else // button 2 is pressed
		{
			String[] choices = {"Upgrage coin generator" + "[" + coinUpgradeCost + "c]",
					"Upgrade energy storage" + "[" + energyUpgradeCost + "c]", "Buy Energy","Exit"};
			JOptionPane.showMessageDialog(null,"Welcome to the shop! Your balance is " + coins);
			JOptionPane.showMessageDialog(null, "Everytime you buy, the cost will increase by 5",
					"Alert", JOptionPane.WARNING_MESSAGE);
			String choice = (String) JOptionPane.showInputDialog(null, "Choose", "Shop",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
													// default icon // Array of choices // Initial choice
			if (choice.equals(choices[0]) && coins > 5)
			{
				System.out.println("Coin generator upgraded!");
				addCoin++;
				coins -= coinUpgradeCost;
				coinUpgradeCost += 5;
			}
			
			else if (choice.equals(choices[1])& coins > 5)
			{
				System.out.println("Energy storage upgraded");
				coins -= energyUpgradeCost;
				addEnergy += 3;
				energyUpgradeCost += 5;
			}

			else if (choice.equals(choices[2]))
			{
				buyEnergy();
			}
			
			else
			{
				System.out.println("Okay..");
				return;
			}
			
		}
		
		if (coins >= 1000)
		{
			System.out.println("Balance: " + coins);
			JOptionPane.showMessageDialog(null,"Congrats on getting up to 1000! you just wasted your time.");
			System.exit(0);
		}
		
	}

	private void buyEnergy()
	{
		energy += addEnergy;
		coins -= energyPrice;
		if (coins > range ) {
			energyPrice *= 2;
			range += 100;
			System.out.println("Energy price increased");
		} // the energy price will start adding up when the balance of the user
		// is on the range of 100 and the range will increase by 50, if the balance is again greater than the range, then the price will also increase
		System.out.println("Balance: " + coins);
		button1.setEnabled(true);
	}

	public static void main(String[] args)
	{
		new Main();
	}
	
}
