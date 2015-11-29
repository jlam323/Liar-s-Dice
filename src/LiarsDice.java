
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JFrame;


public class LiarsDice extends JApplet{
	
	public LiarsDice() throws IOException {
		this.setContentPane(new GameScreen());
	}

	//main method
	public static void main(String[] args) throws IOException{
		
		System.out.println("Welcome to Liar's Dice!");
		System.out.println("The rules are simple. Each person gets a set of 6 dice.");
		System.out.println("Do not let the other person see your dice. Write them down then the next person will reroll for their's.");
		System.out.println("The goal of the game is to guess how many of a certain number of dice exists among the two of you.");
		System.out.println("The first person decides which dice number to play with and how many they think there are.");
		System.out.println("Example: I think that there are three 1's.");
		System.out.println("The next player either calls 'liar' and both reveal, or they up the ante and call a higher number of a certain dice face.");
		System.out.println("Once someone calls 'liar', both players reveal their dice. If it was not a lie, the person who called 'liar' loses.");
		System.out.println("If it was a lie and not enough of the certain dice face is present, the 'liar' loses.");
		System.out.println("Click the 'Roll Dice' button to begin and have fun!");
		
		
		//create a window
		JFrame window = new JFrame();
		
		//set the window title
		window.setTitle("Liar's Dice");
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GameScreen());
		window.pack();
		window.show();
	}
	/*
	public static void main(String[] args) throws IOException {

		String input, i2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do{
			System.out.println ("Are you ready player?");
			input = br.readLine();

			System.out.println("Here are your 6 dice");


			for(int count=0; count < 6; count++){
				System.out.println(1 + (int)(Math.random() * ((6 - 1) + 1)));
			}

			System.out.println("New game?");
			i2 = br.readLine();



		}while (!input.equals("exit"));

	}*/

}

//GameScreen.setLayout(null);
