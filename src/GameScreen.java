import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

/*
 * GUI class for the game. Displays and a board with a button to roll the dice.
 * Displays dice images for the roll.
 * 
 */
public class GameScreen extends JPanel{
	
	//Dice objects for each of the 6 dice
	Dice one = new Dice();
	Dice two = new Dice();
	Dice three = new Dice();
	Dice four = new Dice();
	Dice five = new Dice();
	Dice six = new Dice();
	
	int r[] = new int [6];	//values of rolls

	BufferedImage img1, img2, img3, img4, img5, img6;	//images for the dice
	
	//Player 1 dice
	int d[] = new int [6];
	
	//Player 2 dice
	int dd[] = new int [6];
	
	//total number of each dice face
	int f[] = new int [6];
	
	//track if the dice was rerolled
	boolean reroll = false;
	
	boolean run = false;
	
	JButton button;
	
	//default constructor
	GameScreen() throws IOException{
		
		//create JPanel
		JPanel screen = new JPanel();
		
		//add dice to the screen
		screen.setLayout(new GridLayout(3, 2, 4, 4));
		screen.add(one);
		screen.add(two);
		screen.add(three);
		screen.add(four);
		screen.add(five);
		screen.add(six);

		//call class to make the dice roll button
		button = addButton();

		
		//add to the actual game screen
		this.add(button,BorderLayout.SOUTH);
		this.add(screen, BorderLayout.NORTH);
		
		

	}
	
	//method to create a button on the screen
	public JButton addButton(){
		
		//create the button with settings
		JButton b = new JButton("Roll Dice");
		b.setBounds(15, 25, 10, 20);

		//set the action listener
		b.addActionListener(new pressButton());
		
		//return the button
		return b;
	}
	
	
	
	//Action Listener class
	public class pressButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
						
			//roll all the dice
			one.roll();
			two.roll();
			three.roll();
			four.roll();
			five.roll();
			six.roll();

			//record values of the rolls
			r[0] = one.getNum();
			r[1] = two.getNum();
			r[2] = three.getNum();
			r[3] = four.getNum();
			r[4] = five.getNum();
			r[5] = six.getNum();


			if ((reroll == false) && (run == false)){
				//record player 1's dice
				for (int count = 0; count <= 5; count ++)
					d[count] = r[count];
				reroll = true;
			}
			//to check if the person is rolling again and should not
			else if ((reroll == true) && (run == false)){

				//record player 2's dice
				for (int count = 0; count <= 5; count ++)
					dd[count] = r[count];
				run = true;
			}
			else if (run == true){


				//calculate total number of dice faces
				for (int count = 0; count <= 5; count ++)
					f[count] = d[count] + dd[count];

				try{
					playGame p = new playGame(f);
				}catch(IOException e1){}
			}			
		}
	}
}