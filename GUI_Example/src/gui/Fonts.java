package gui;

import java.util.ArrayList;
import javax.swing.ImageIcon;

import gui.GUI;

public class Fonts 
{
	private static ImageIcon icon;
	private final static int NUM_OFFSET = 48;
	private final static int LETTER_OFFSET = 56;
	private final static int NUM_CUTOFF = 65;
	private final static int SPACE = 32;
	private final static int SPACE_OFFSET = -3;
	
	static ArrayList <ImageIcon> font = new ArrayList <ImageIcon> ();
	static ArrayList <ImageIcon> convertText = new ArrayList <ImageIcon> ();
	
	public static ArrayList <ImageIcon> addFont(String text, String textType)
	{
		for (int num = 0; num < 9; num++)
		{
			icon = new ImageIcon(GUI.class.getResource(textType + num + ".png"));
			font.add(icon);
		}//end of for loop
		
		for (char letter = 'A'; letter <= 'Z'; letter++)
		{
			icon = new ImageIcon(GUI.class.getResource(textType + letter + ".png"));
			font.add(icon);
		}//end of for loop
		
		icon = new ImageIcon(GUI.class.getResource("/hud/Hud/Space.png"));
		font.add(icon);
		
		return stringToFont(text, font);
	}//end of addHud
	
	public static ArrayList <ImageIcon> stringToFont(String text, ArrayList <ImageIcon> font)
	{
		for (int x = 0; x < text.length(); x++)
		{
			if ((int) text.charAt(x) == SPACE)
			{
				convertText.add(font.get(((int) text.charAt(x) - SPACE_OFFSET)));
			}//end of if
			else if ((int) text.charAt(x) < NUM_CUTOFF)
			{
				convertText.add(font.get(((int) text.charAt(x) - NUM_OFFSET)));
			}//end of if
			else
			{
				convertText.add(font.get(((int) text.charAt(x) - LETTER_OFFSET)));
			}//end of else
		}//end of for loop
		
		return convertText;
	}//end of stringToFont
}//end of Fonts
