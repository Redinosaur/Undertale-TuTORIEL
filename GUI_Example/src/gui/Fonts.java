package gui;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import gui.GUI;

/**
 * This class will convert a string to font images
 * 
 * @author Alden Bauman
 *
 */
public class Fonts 
{
	private static ImageIcon icon;
	private final static int NUM_OFFSET = 48;
	private final static int LETTER_OFFSET = 55;
	private final static int NUM_CUTOFF = 65;
	private final static int SPACE = 32;
	private final static int SPACE_OFFSET = -4;
	
	static ArrayList <ImageIcon> font = new ArrayList <ImageIcon> ();
	static ArrayList <ImageIcon> convertText = new ArrayList <ImageIcon> ();
	static ArrayList <ImageIcon> num = new ArrayList <ImageIcon> ();
	
	/**
	 * Creates ArrayList of ImageIcons based on textType
	 * 
	 * @param	text		length of box
	 * @param	textType	height of box
	 * @return	font
	 * @post	none
	*/
	public static ArrayList <ImageIcon> addFont(String text, String textType)
	{
		for (int num = 0; num <= 9; num++)
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
		
		icon = new ImageIcon(GUI.class.getResource("/hud/Hud/Slash.png"));
		font.add(icon);
		
		return stringToFont(text, font);
	}//end of addHud
	
	/**
	 * Creates ArrayList of ImageIcons based on textType
	 * 
	 * @param	text	string to be converted
	 * @param	font	text to be converted
	 * @return	convertText
	 * @post	text is converted
	*/
	public static ArrayList <ImageIcon> stringToFont(String text, ArrayList <ImageIcon> font)
	{
		for (int x = 0; x < text.length(); x++)
		{
			if ((int) text.charAt(x) == SPACE)
			{
				convertText.add(font.get(((int) text.charAt(x) - SPACE_OFFSET)));
			}//end of if
			else if (text.charAt(x) == '/')
			{
				convertText.add(font.get(font.size() - 1));
			}//end of else if
			else if ((int) text.charAt(x) < NUM_CUTOFF)
			{
				convertText.add(font.get(((int) text.charAt(x) - NUM_OFFSET)));
			}//end of else if
			else
			{
				convertText.add(font.get(((int) text.charAt(x) - LETTER_OFFSET)));
			}//end of else
		}//end of for loop
		
		return convertText;
	}//end of stringToFont

	/**
	 * Creates font of numbers
	 * 
	 * @param	none
	 * @return	num
	 * @post	numbers provided for health bar
	*/
	public static ArrayList <ImageIcon> intToFont()
	{
		for (int x = 0; x <= 9; x++)
		{
			icon = new ImageIcon(GUI.class.getResource("/hud/Hud/" + x + ".png"));
			num.add(icon);
		}//end of for loop
		
		return num;
	}//end of stringToFont
}//end of Fonts
