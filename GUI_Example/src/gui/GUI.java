package gui;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import lib.Constants;
import javax.swing.JLabel;

public class GUI 
{

	private JFrame frame;
	private ImageIcon icon;
	private final int BUTTON_WIDTH = 220;
	private final int BUTTON_HEIGHT = 84;
	ArrayList <ImageIcon> text = new ArrayList <ImageIcon>();
	private int selected = 0;
	JLabel fight;
	JLabel item;
	JLabel mercy;
	JLabel act;
	JLabel backgroundLines;

	/**
	 * Create the application.
	 */
	public GUI() 
	{
		initialize();
		frame.setVisible(true);
	}//end of GUI

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() 
	{
		//Viewing Window
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 948, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Fight Button
		fight = new JLabel("");
		fight.setBackground(Color.BLACK);
		icon = new ImageIcon(GUI.class.getResource(Constants.fightImage));
		fight.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
		fight.setBounds(10, 453, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(fight);
		
		//Act Button
		act = new JLabel("");
		act.setBackground(Color.BLACK);
		icon = new ImageIcon(GUI.class.getResource(Constants.actImage));
		act.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
		act.setBounds(240, 453, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(act);
		
		//Item Button
		item = new JLabel("");
		item.setBackground(Color.BLACK);
		icon = new ImageIcon(GUI.class.getResource(Constants.itemImage));
		item.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
		item.setBounds(470, 453, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(item);
		
		//Mercy Button
		mercy = new JLabel("");
		mercy.setBackground(Color.BLACK);
		icon = new ImageIcon(GUI.class.getResource(Constants.mercyImage));
		mercy.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
		mercy.setBounds(700, 453, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(mercy);
		
		//BackgroundLines
		backgroundLines = new JLabel("");
		icon = new ImageIcon(GUI.class.getResource(Constants.backgroundLines));
		backgroundLines.setIcon(resize(icon, 910, 371));
		backgroundLines.setBackground(Color.BLACK);
		backgroundLines.setBounds(10, 11, 910, 371);
		frame.getContentPane().add(backgroundLines);
		
		convertText("BLAH BLAH", "/hud/Hud/");
		
		selection();
	}//end of initialize
	
	private void convertText(String word, String file)
	{
		text.addAll(Fonts.addFont(word, file));
		
		for (int x = 0; x < text.size(); x++)
		{
			JLabel button = new JLabel("");
			button.setBackground(Color.BLACK);
			button.setIcon(resize(text.get(x), 40, 50));
			button.setBounds(400 + 45 * x, 400, 40, 50);
			frame.getContentPane().add(button);
		}//end of for loop
	}//end of convertText
	
	//Resizes Buttons
	private ImageIcon resize(ImageIcon img, int w, int h)
	{
		return new ImageIcon(img.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
	}//end of resize
	
	private void selection()
	{
		
		
			switch (selected)
			{
				case 0: icon = new ImageIcon(GUI.class.getResource(Constants.fightSelected));
						fight.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.actImage));
						act.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						break;
						
				case 1: icon = new ImageIcon(GUI.class.getResource(Constants.actSelected));
						act.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.fightImage));
						fight.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.itemImage));
						item.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						break;
						
				case 2: icon = new ImageIcon(GUI.class.getResource(Constants.actImage));
						act.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.mercyImage));
						mercy.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.itemSelected));
						item.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						break;
						
				case 3: icon = new ImageIcon(GUI.class.getResource(Constants.mercySelected));
						mercy.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.itemImage));
						item.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						break;
			}
			
			
		
	}
}//end of class GUI
