import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import java.util.Random;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

class Dice extends JPanel {
	
	int result; //the dice roll result
	
	BufferedImage img1, img2, img3, img4, img5, img6 = null;
	BufferedImage current;
	
	//default constructor
	public Dice() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(100,100));
		result = roll();

		try{
			img1 = ImageIO.read(new File("one.png"));
			img2 = ImageIO.read(new File("two.png"));
			img3 = ImageIO.read(new File("three.png"));
			img4 = ImageIO.read(new File("four.png"));
			img5 = ImageIO.read(new File("five.png"));
			img6 = ImageIO.read(new File("six.png"));
		}catch(IOException e){
			
		}
	}
	
	//method to randomize a dice roll
	public int roll() {
		Random r = new Random();
		int num = r.nextInt(6) + 1; // Range 1-6
		
		//display the correct picture depending on the dice roll
		if (num == 1)
			current = img1;
		else if (num == 2)
			current = img2;
		else if (num == 3)
			current = img3;
		else if (num == 4)
			current = img4;
		else if (num == 5)
			current = img5;
		else
			current = img6;
		
		
		repaint();
		return num;
	}//end roll
	
	
	//method to return the top face of the dice roll
	public int getNum(){
		return result;
	}
	
	public void paint(Graphics g){
		g.drawImage(current,  0,  0,  null);
	}
	
	//DONT CARE ABOUT THE STUFF BEFORE
	//TO DO: ADD CLASS TO SHOW DICE IMAGE
	
	
}