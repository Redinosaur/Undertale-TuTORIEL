package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import lib.Constants;

/**
 * This class will initialize the frame and its contents
 * 
 * @author Alden Bauman
 *
 */
public class GUI 
{

	private JFrame frame;
	private ImageIcon icon;
	private final int BUTTON_WIDTH = 220;
	private final int BUTTON_HEIGHT = 84;
	private final int MAX_HEALTH = 93;
	private final int WINDOW_LENGTH = 1148;
	private final int WINDOW_HEIGHT = 800;
	private final int HEART_MOVE = 230;
	ArrayList <ImageIcon> text = new ArrayList <ImageIcon>();
	ArrayList <ImageIcon> health = new ArrayList <ImageIcon>();
	ImageIcon damageTaken = new ImageIcon(GUI.class.getResource(Constants.healthEmpty));
	ImageIcon healed = new ImageIcon(GUI.class.getResource(Constants.healthFull));
	private int selected = 0;
	private int x = 100, y = 300, length = 500, height = 200; //default dimensions and starting position for battle box
	private int heartStartX = 133;
	private int heartStartY = 700;
	private int lineWidth = 4;
	private int currentHealth = MAX_HEALTH;
	private int start = 0;
	private int damage = currentHealth;
	private double gravityFall = 0;
	private boolean damaged = false;
	private boolean gravity = false;
	private boolean jumped = false;
	private boolean falling = true;
	JLabel health1;
	JLabel health2;
	JLabel fight;
	JLabel item;
	JLabel mercy;
	JLabel act;
	JLabel backgroundLines;
	JLabel heart;
	JLabel boxTop;
	JLabel boxLeft;
	JLabel boxRight;
	JLabel boxBottom;
	ArrayList <JLabel> healthBar = new ArrayList <JLabel>();
	boolean rightPressed = false;
	boolean leftPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;
	int battle = 0;

	/**
	 * Create the application.
	 */
	public GUI() 
	{
		initialize();
		frame.setVisible(true);
		movePlayer.execute();
	}//end of GUI

	/**
	 * Initializes frame
	 * @pre		none
	 * @param	none
	 * @return	none
	 * @post	contents of screen printed
	 */
	public void initialize() 
	{
		//Viewing Window
		frame = new JFrame();
		frame.addKeyListener(new keyListener());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, WINDOW_LENGTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Fight Button
		fight = new JLabel("");
		fight.setBackground(Color.BLACK);
		icon = new ImageIcon(GUI.class.getResource(Constants.fightImage));
		fight.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
		fight.setBounds(110, 666, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(fight);
		
		//Act Button
		act = new JLabel("");
		act.setBackground(Color.BLACK);
		icon = new ImageIcon(GUI.class.getResource(Constants.actImage));
		act.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
		act.setBounds(340, 666, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(act);
		
		//Item Button
		item = new JLabel("");
		item.setBackground(Color.BLACK);
		icon = new ImageIcon(GUI.class.getResource(Constants.itemImage));
		item.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
		item.setBounds(570, 666, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(item);
		
		//Mercy Button
		mercy = new JLabel("");
		mercy.setBackground(Color.BLACK);
		icon = new ImageIcon(GUI.class.getResource(Constants.mercyImage));
		mercy.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
		mercy.setBounds(800, 666, BUTTON_WIDTH, BUTTON_HEIGHT);
		frame.getContentPane().add(mercy);
		
		//creates hud
		health.addAll(Fonts.intToFont());
		start = convertText("CHARA  LV 19     HP           / " + MAX_HEALTH, "/hud/Hud/", 27);
		
		//double digit health label
		health1 = new JLabel("");
		health1.setBackground(Color.BLACK);
		health1.setBounds(120 + start, 620, 40, 50);
		frame.getContentPane().add(health1);
		
		//single digit health label
		health2 = new JLabel("");
		health2.setBackground(Color.BLACK);
		health2.setBounds(145 + start, 620, 40, 50);
		frame.getContentPane().add(health2);
		
		//initializes health bar
		for (int x = 0; x < MAX_HEALTH * 2; x += 2)
		{
			JLabel healthBars = new JLabel("");
			healthBars.setBounds(115 - MAX_HEALTH * 2 + x + start, 630, 2, 30);
			icon = new ImageIcon(GUI.class.getResource(Constants.healthFull));
			healthBars.setIcon(resize(icon, 2, 30));
			healthBar.add(healthBars);
			
			frame.getContentPane().add(healthBars);
		}//end of for loop
		
		//creates centered battle box of given dimensions and starting y value
		battleBox(length, height, y);
		
		//user selection on buttons
		selection();
	}//end of initialize
	
	/**
	 * Initializes battle box
	 * 
	 * @param	l	length of box
	 * @param	h	height of box
	 * @param	y	starting y position
	 * @return	none
	 * @post	the	box is printed on screen
	*/
	private void battleBox(int l, int h, int y)
	{
		//centers battle box
		x = (WINDOW_LENGTH - l) / 2;
		
		//top of box
		icon = new ImageIcon(GUI.class.getResource(Constants.battleBox));
		boxTop = new JLabel("");
		boxTop.setIcon(resize(icon, l, h));
		boxTop.setBounds(x, y, l, lineWidth);
		frame.getContentPane().add(boxTop);
		
		//bottom of box
		boxBottom = new JLabel("");
		boxBottom.setIcon(resize(icon, l, lineWidth));
		boxBottom.setBounds(x, y + h, l, lineWidth);
		frame.getContentPane().add(boxBottom);
		
		//left side of box
		boxLeft = new JLabel("");
		boxLeft.setIcon(resize(icon, lineWidth, h));
		boxLeft.setBounds(x, y, lineWidth, h);
		frame.getContentPane().add(boxLeft);
		
		//right side of box
		boxRight = new JLabel("");
		boxRight.setIcon(resize(icon, lineWidth, h));
		boxRight.setBounds(x + l, y, lineWidth, h);
		frame.getContentPane().add(boxRight);
		
		//initializes heart
		heart = new JLabel("");
		icon = new ImageIcon(GUI.class.getResource(Constants.heart));
		heart.setIcon(resize(icon, 20, 19));
		heart.setBounds(heartStartX, heartStartY, 20, 19);
		frame.getContentPane().add(heart);
	}//end of battleBox
	
	/**
	 * Prints out converted text
	 * 
	 * @param	word	string to be converted to ImageIcons
	 * @param	file	class file to get font pictures
	 * @param	start	length of string to health
	 * @return	start	offset for health
	 * @post	the	ArrayList of ImageIcons is printed on the screen
	*/
	private int convertText(String word, String file, int start)
	{
		//converts given string to an arrayList of imageIcons
		text.addAll(Fonts.addFont(word, file));
		int s = start;
		start = 0;
		
		//finds appropriate starting offset for health
		for (int x = 0; x < s; x++)
		{
			start += 25;
		}//end of for loop
		
		//prints out hud
		for (int x = 0; x < text.size(); x++)
		{
			JLabel hud = new JLabel("");
			hud.setBackground(Color.BLACK);
			hud.setIcon(resize(text.get(x), 20, 25));
			hud.setBounds(120 + 25 * x, 620, 40, 50);
			frame.getContentPane().add(hud);
		}//end of for loop
		
		return start;
	}//end of convertText
	
	/**
	 * Resizes images
	 * Provided by Aaron Lampert
	 * @param	img		image for scaling
	 * @param	w		desired width
	 * @param	h		desired height
	 * @return	img		resized image
	 * 
	 * @post	the image is resized
	 */
	private ImageIcon resize(ImageIcon img, int w, int h)
	{
		return new ImageIcon(img.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
	}//end of resize
	
	/**
	 * Button choice
	 * Provided by Aaron Lampert
	 * @param	img		image for scaling
	 * @param	w		desired width
	 * @param	h		desired height
	 * @return	img		resized image
	 * 
	 * @post	the image is resized
	 */
	private void selection()
	{
			switch (selected)
			{
				//fight button
				case 0: icon = new ImageIcon(GUI.class.getResource(Constants.fightSelected));
						fight.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.actImage));
						act.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						heart.setLocation(HEART_MOVE * selected + heartStartX, heartStartY);
						break;
						
				//act button
				case 1: icon = new ImageIcon(GUI.class.getResource(Constants.actSelected));
						act.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.fightImage));
						fight.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.itemImage));
						item.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						heart.setLocation(HEART_MOVE * selected + heartStartX, heartStartY);
						break;
						
				//item button
				case 2: icon = new ImageIcon(GUI.class.getResource(Constants.actImage));
						act.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.mercyImage));
						mercy.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.itemSelected));
						item.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						heart.setLocation(HEART_MOVE * selected + heartStartX, heartStartY);
						break;
						
				//mercy button
				case 3: icon = new ImageIcon(GUI.class.getResource(Constants.mercySelected));
						mercy.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						icon = new ImageIcon(GUI.class.getResource(Constants.itemImage));
						item.setIcon(resize(icon, BUTTON_WIDTH, BUTTON_HEIGHT));
						heart.setLocation(HEART_MOVE * selected + heartStartX, heartStartY);
						break;
			}//end of switch case
			
			
		
	}//end of selection

	/**
	 * Prints health bar
	 * @param	health		health befor modification
	 * @param	damage		did they heal or were they hurt?
	 * @return	none
	 * 
	 * @post	Prints health bar
	 */
	private void setHealthBar(int health, int damage)
	{
		if (damage > health)
		{
			while (damage > health)
			{
				healthBar.get(health).setIcon(resize(damageTaken, 2, 30));
				health++;
			}
		}//end of if
		else
		{
			while (damage < health)
			{
				healthBar.get(health - 1).setIcon(resize(healed, 2, 30));
				health--;
			}
		}//end of else
	}//end of setHealthBar
	
	
	SwingWorker<Object, Object> movePlayer = new SwingWorker<Object, Object>()
	{
		/**
		 * Infinite background loop that creates tick rate
		 * 
		 * @param	none
		 * @return	none
		 * @post	none
		 * @Override
		*/
		protected Object doInBackground() throws Exception 
		{
			while(true)
			{
				if (heart.getX() < (x + length - lineWidth * 5))
				{
					if(rightPressed)
					{
						heart.setLocation(heart.getX() + 2, heart.getY());
					}//end of if
				}//end of if
					
				if (heart.getX() > (x + lineWidth))
				{
					if(leftPressed)
					{
						heart.setLocation(heart.getX() - 2, heart.getY());
					}//end of if
				}//end of if
				
				if (heart.getY() > (y + lineWidth))
				{
					if(upPressed)
					{
						heart.setLocation(heart.getX(), heart.getY() - 2);
					}//end of if
				}//end of if
					
				if (heart.getY() < (y + height - lineWidth * 5))
				{
					jumped = true;
					if(downPressed)
					{
						heart.setLocation(heart.getX(), heart.getY() + 2);
					}//end of if
					if (gravity && jumped)
					{
						gravityFall += .03;
						
						if (falling && gravityFall < 3)
						{
							gravityFall += .03;
						}
						
						heart.setLocation(heart.getX(), heart.getY() + (int) gravityFall);
					}
				}//end of if
				else
				{
					jumped = false;
					falling = false;
					gravityFall = 0;
				}
				
				//first digit of health
				icon = new ImageIcon(GUI.class.getResource("/hud/Hud/" + (currentHealth / 10) + ".png"));
				health1.setIcon(resize(icon, 20, 25));
				
				//second digit of health
				icon = new ImageIcon(GUI.class.getResource("/hud/Hud/" + (currentHealth % 10) + ".png"));
				health2.setIcon(resize(icon, 20, 25));
				
				if (damage != currentHealth)
				{
					setHealthBar(currentHealth, damage);
					damage = currentHealth;
					damaged = false;
				}//end of if
				
				//tick rate
				Thread.sleep(8);
			}//end of while loop
		
		}//end of doInBackground
	};
			
	/**
	 * This class will detect key presses
	 * 
	 * @author Alden Bauman
	 *
	 */
	class keyListener implements KeyListener
	{
		/**
		 * Starts movement on key press
		 * 
		 * @param	e		key was pressed
		 * @return	none
		 * @post	movement is started based on key press
		 * @Override
		*/
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if (battle < 2)
				{
					if (selected < 3)
					{
						selected++;
						selection();
					}//end of if
				}//end of if
				else
				{
					rightPressed = true;
				}//end of else
			}//end of if
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if (battle < 2)
				{
					if (selected > 0)
					{
						selected--;
						selection();
					}//end of if
				}//end of if
				else
				{
					leftPressed = true;
				}//end of else
			}//end of if
			
			if(e.getKeyCode() == KeyEvent.VK_Z)
			{
				if (battle > 1)
				{
					battle = 0;
					selected = 0;
					selection();
				}//end of if
				else if (battle > 0)
				{
					heart.setLocation(WINDOW_LENGTH / 2, WINDOW_HEIGHT / 2);
					battle++;
				}//end of else if
				else
				{
					battle++;
				}//end of else
					
			}//end of if
			if(e.getKeyCode() == KeyEvent.VK_X)
			{
				if (damaged == false)
				{
					if (currentHealth > 0)
					{
						currentHealth -= 1;
						damaged = true;
					}//end of if
				}//end of if
				if (battle == 1)
				{
					battle--;
				}//end of if
			}//end of if
			if(e.getKeyCode() == KeyEvent.VK_C)
			{
				if (damaged == false)
				{
					if (currentHealth < MAX_HEALTH)
					{
						currentHealth += 1;
						damaged = true;
					}//end of if
				}//end of if
			}//end of if
			
			if(e.getKeyCode() == KeyEvent.VK_G)
			{
				gravity = !gravity;
				gravityFall = 0;
			}//end of if
			
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				if (battle > 1)
				{
					if (!falling || !gravity)
					{
						upPressed = true;	
						jumped = true;
					}
				}//end of if

			}//end of if
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				if (battle > 1)
				{
					downPressed = true;
				}//end of if
			}//end of if
		}//end of keyPressed

		
		/**
		 * Stops movement on key release
		 * 
		 * @param	e		key was released
		 * @return	none
		 * @post	movement is stopped based on key release
		 * @Override
		*/
		public void keyReleased(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				rightPressed = false;
			}//end of if
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				leftPressed = false;
			}//end of if
			
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				upPressed = false;
				
				if (!falling)
				{
					gravityFall -= 1;
				}//end of if
				falling = true;
			}//end of if
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				downPressed = false;
			}//end of if
		}//end of keyReleased

		@Override
		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
		}//end of keyTyped
	}//end of class keyListener
}//end of class GUI
