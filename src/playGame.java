import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.Random;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.*;

import java.io.*;


public class playGame {

	public playGame(int f[]) throws IOException{

		String input;
		int curnum;	//current dice face value
		int quantity;//number of that dice present
		boolean call;

		boolean lose = false;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(lose == false){

			//*******PLAYER 1 DICE BET*********//
			System.out.println("");
			System.out.println("Player 1, choose a die face.");
			System.out.println("[1], [2], [3], [4], [5], [6]");

			curnum = Integer.parseInt(br.readLine());

			System.out.println("");
			System.out.println("How many " + curnum + "'s do you think there are? (must be greater quantity than last guess)");
			quantity = Integer.parseInt(br.readLine());


			//*******PLAYER 2 LIAR CALL********//
			System.out.println("");
			System.out.println("Player 2, do you call Player 1 a liar?");
			System.out.println("[1] yes, [2] no");
			input = br.readLine();

			//called out
			if (input.equals("1")){
				lose = callOut(quantity, f[curnum-1], curnum);


				if(lose == true){
					System.out.println("Player 1 loses!");
					break;
				}
				else
					System.out.println("Player 2 loses!");
			}


			//********PLAYER 2 DICE BET*******//
			System.out.println("");
			System.out.println("Player 2, choose a die face.");
			System.out.println("[1], [2], [3], [4], [5], [6]");

			curnum = Integer.parseInt(br.readLine());

			System.out.println("");
			System.out.println("How many " + curnum + "'s do you think there are? (must be greater quantity than last guess)");
			quantity = Integer.parseInt(br.readLine());


			//*******PLAYER 1 LIAR CALL********//
			System.out.println("");
			System.out.println("Player 1, do you call Player 2 a liar?");
			System.out.println("[1] yes, [2] no");
			input = br.readLine();

			//called out
			if (input.equals("1")){
				if (curnum == 1)
					lose = callOut(quantity, f[curnum-1], curnum);


				if(lose == true){
					System.out.println("Player 2 loses!");
					break;
				}
				else
					System.out.println("Player 1 loses!");
			}

		}

	}
	
	
	public boolean callOut(int guess, int real, int diceface){
		boolean lie = false;
		
		if (guess > real){
			lie = true;
			System.out.println("Liar! There were only " + real + " dices of " + diceface + "!");
		}
		return lie;
	}
	
}
