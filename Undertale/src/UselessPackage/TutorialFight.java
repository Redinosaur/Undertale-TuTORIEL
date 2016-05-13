package UselessPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.SwingWorker;

import java.awt.Font;

import javax.swing.SwingConstants;


public class TutorialFight {
	
	/** UGLY CREATION OF ALL THE DIALOGUE STRINGS **/
	String string1 = new String("Howdy, I'm FLOWEY! FLOWEY the FLOWER! ");	// strings for dialogue
	String string2 = new String("You're new to the UNDERGROUND, aren'tcha?");
	String string3 = new String("Golly, you must be so confused!");
	String string4 = new String("Someone ought to teach you how things work around here!");
	String string5 = new String("I guess little old me 	will have to do.");
	String string6 = new String("See that heart? That is your SOUL, the very culmination of your being!");
	String string7 = new String("Your SOUL starts off weak, but can grow strong ");
	String string7p2 = new String("if you gain a lot of LV.");
	String string8 = new String("What's LV stand for?  Why, LOVE of course!");
	String string9 = new String("You want some LOVE, don't you?");
	String string10 = new String("Don't worry, I'll share some with you!");
	String string11 = new String("Down here, LOVE is shared through...");
	String string12 = new String("Little white... 'friendliness pellets.'");
	String string13 = new String("Are you ready?");
	String string14 = new String("Move around!  Get as many as you can!");
	String string14p2 = new String("Hey, buddy, you missed 'em.  Let's try again.");
	String string14p3 = new String("You know what's going on around here, don't you?");
	String string15 = new String("You IDIOT!");
	String string16 = new String("In this world, it's kill or BE killed!");
	String string17 = new String("Why would ANYONE pass up an opportunity like this?");
	String string18 = new String("Die.");
	String string19 = new String("...");
	String string1p2 = new String();
	
	
	/** AUDIO **/
	Clip audioClipHit;
	Clip audioClip;
	Clip audioClips;
	Clip audioEvil;
	Clip audioSlow;

	
	/** PATHWAYS **/
	String path1 = new String("/images/flowey1.png");	// gathers pathways for images
	String path2 = new String("/images/flowey1p2.png");
	String path3 = new String("/images/flowey1la.png");
	String healthlink = new String("/images/health22.png");
	String blank = new String("/images/blank.png");
	String trollflowey = new String("/images/floweyvil.png");
	String floweyMad = new String("/images/floweyMad.png");
	String pelletpath = new String("/images/pelletother.png"); // laying down
	String pelletpath2 = new String("/images/pellet.png"); // upside down
	String bip  = "/songs/flowey.wav";	// audio clip pathway

	
	/** BOOLEANS **/
	boolean rightPressed = false;	// declaring variables
	boolean leftPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;
	boolean talking = false;
	private boolean finished = false;
	boolean wink = false;
	boolean angry = false;
	boolean fire = false;
	boolean spin = false;
	boolean upsideDown = false;
	boolean die = false;
	boolean relocate = false;
	
	
	/** ARRAYLISTS **/
	private ArrayList <String> textBox = new ArrayList <String> ();	// more variables
	private ArrayList <String> allTheText = new ArrayList <String> ();
	private ArrayList <JLabel> text = new ArrayList <JLabel> ();
	private ArrayList <JLabel> pellets = new ArrayList <JLabel> ();
	
	
	/** ALL THE INTS YOU CAN FIND FOLKS **/
	int count = 0;
	int countMove = 0, countMove2 = 0, countMove3 = 0;
	int count2 = 0, num2 = 0;
	int line = 0, skip = 1;
	int spinners = 0;
	private int paragraph = 9;
	private int movePellets,movePellets2 = 0;
	
	
	/** WRAPPER CLASSES SO I CAN GET THEM CHECKED OFF **/
	Integer num = new Integer(0);
	Double move = new Double(0.5);
	
	
	/** DIMENSIONS OF THE DIALOGUE BOX, FINALS **/
	final int width = 21;
	final int height = 23;
		
	
	/** CREATING THE FLOWEY SPRITES **/
	ImageIcon floweyI1 = new ImageIcon(path1);	// different images
	ImageIcon floweyI2 = new ImageIcon(path2);
	
	
	/** JLABELS **/
	private JFrame frame;	// globaj frame variables
	JLabel heart;
	JLabel text2;
	JLabel texts;
	JLabel flowey;
	JLabel bubble;
	JLabel healthBar;
	JLabel left;
	JLabel right;
	JLabel up;
	JLabel down;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TutorialFight window = new TutorialFight();	// launches the program
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public TutorialFight() 
	{
		initialize(); // calls the main method
		movePlayer.execute();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		/** UGLY CREATION OF THE ARRAY OF DIALOGUE STRINGS **/
		allTheText.add(string1);	// adds the strings to an arraylist
		allTheText.add(string2);
		allTheText.add(string3);
		allTheText.add(string4);
		allTheText.add(string5);
		allTheText.add(string6);
		allTheText.add(string7);
		allTheText.add(string7p2);
		allTheText.add(string8);
		allTheText.add(string9);
		allTheText.add(string10);
		allTheText.add(string11);
		allTheText.add(string12);
		allTheText.add(string13);
		allTheText.add(string14);
		allTheText.add(string14p2);
		allTheText.add(string14p3);
		allTheText.add(string15);
		allTheText.add(string16);
		allTheText.add(string17);
		allTheText.add(string18);
		textBox.add(allTheText.get(paragraph));
		
		
		/** CREATION OF JFRAMES/JLABELS **/
		frame = new JFrame();	// sets the frame
		frame.addKeyListener(new keyListener());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		healthBar = new JLabel("  ");	// sets healthbar
		healthBar.setIcon(new ImageIcon(TutorialFight.class.getResource("/images/health11.png")));
		healthBar.setBounds(195, 375, 257, 42);
		frame.getContentPane().add(healthBar);
		
		JLabel dialogue = new JLabel("");	// sets dialogue/speech bubble
		dialogue.setIcon(new ImageIcon(TutorialFight.class.getResource("/images/white1.png")));
		dialogue.setBounds(229, 216, 178, 161);
		frame.getContentPane().add(dialogue);
		
		flowey = new JLabel("");	// sets flowey
		flowey.setIcon(new ImageIcon(TutorialFight.class.getResource("/images/flowey1.png")));
		flowey.setBounds(270, 86, 96, 126);
		frame.getContentPane().add(flowey);
		
		heart = new JLabel("  ");	// gets the heart
		heart.setIcon(new ImageIcon(TutorialFight.class.getResource("/images/grgrgrgr.png")));
		heart.setBounds(306, 325, 21, 23);
		frame.getContentPane().add(heart);
		
		
		/** ARRAYLIST **/
		for (int x = 0; x < 5; x++)	// adds the arraylist of pellets
		{
			JLabel pellet = new JLabel("");
			pellet.setIcon(new ImageIcon(TutorialFight.class.getResource("/images/pellet.png")));
			pellet.setBounds(306, -50, 21, 23);
			frame.getContentPane().add(pellet);
			pellets.add(pellet);
		}
		
		
		
		/** SETS THE FONT **/
		for (int x = 0; x < 4; x++)
		{
			texts = new JLabel("  ");
			texts.setVerticalAlignment(SwingConstants.TOP);
			texts.setFont(new Font("DotumChe", Font.PLAIN, 16));
			texts.setForeground(Color.BLACK);
			texts.setBounds(407, 86 + 20 * x, 200, 23);
			frame.getContentPane().add(texts);
			text.add(texts);
		}
		
		
		/** MORE JLABLES **/
		bubble = new JLabel("  ");	// calls the other speech bubble
		bubble.setForeground(Color.BLACK);
		bubble.setBackground(Color.WHITE);
		bubble.setIcon(new ImageIcon(TutorialFight.class.getResource("/images/bubble2.png")));
		bubble.setBounds(376, 60, 246, 127);
		frame.getContentPane().add(bubble);
		bubble.setText("test");
		
		left = new JLabel("  ");	// different borders
		left.setBounds(230, 216, 6, 161);
		frame.getContentPane().add(left);
		
		up = new JLabel("  ");
		up.setBounds(229, 216, 180, 8);
		frame.getContentPane().add(up);
		
		right = new JLabel("  ");
		right.setBounds(402, 216, 6, 161);
		frame.getContentPane().add(right);
		
		down = new JLabel("  ");
		down.setBounds(229, 369, 178, 8);
		frame.getContentPane().add(down);
		frame.setBounds(100, 100, 648, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/** UGLY CREATION OF AUDIO STRING **/
		String bip = new String("Resource/songs/mus_flowey.wav");	// gets the audio files
		String hit = new String("Resource/songs/hit.wav");
		String evilTalk = new String("Resource/songs/durr.wav");
		String bipper  = "Resource/songs/floweyTalk.wav";
		String slowpoke = new String("Resource/songs/mus_flowey2.wav");
		
		File audioFile = new File(bip);
		File audioHit = new File(hit);
		File audioTalk = new File(evilTalk);
		File fileSlow = new File(slowpoke);		
		
		
		/** UGLY IMPORTATION OF AUDIO **/
		/** audio for the music **/
		AudioInputStream audioStream;	// opens audio files
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			try {
				audioClip = (Clip) AudioSystem.getLine(info);
				audioClip.open(audioStream);
				audioClip.loop(6000);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/** audio for the talk **/
		AudioInputStream talkity;	// opens audio files
		try {
			talkity = AudioSystem.getAudioInputStream(audioTalk);
			AudioFormat format = talkity.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			try {
				audioEvil = (Clip) AudioSystem.getLine(info);
				audioEvil.open(talkity);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/** audio for the hit **/
		AudioInputStream hitted;	// opens audio files
		try {
			hitted = AudioSystem.getAudioInputStream(audioHit);
			AudioFormat format = hitted.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			try {
				audioClipHit = (Clip) AudioSystem.getLine(info);
				audioClipHit.open(hitted);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		/** audio for the speech bubble **/
		File audioFiles = new File(bipper);
		AudioInputStream audioStreams;
		try {
			audioStreams = AudioSystem.getAudioInputStream(audioFiles);
			AudioFormat formats = audioStreams.getFormat();
			DataLine.Info infos = new DataLine.Info(Clip.class, formats);
			
			try {
				audioClips = (Clip) AudioSystem.getLine(infos);
				audioClips.open(audioStreams);
				
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		/** audio for the slow **/
		AudioInputStream audioStreamSlow;
		try {
			audioStreamSlow = AudioSystem.getAudioInputStream(fileSlow);
			AudioFormat formats = audioStreamSlow.getFormat();
			DataLine.Info infos = new DataLine.Info(Clip.class, formats);
			
			try {
				audioSlow = (Clip) AudioSystem.getLine(infos);
				audioSlow.open(audioStreamSlow);
				
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	
	/** ALL THE COOL STUFF **/
	SwingWorker<Object, Object> movePlayer = new SwingWorker<Object, Object>()	// swingworker that infinitely runs the game
	{
	@Override 
	protected Object doInBackground() throws Exception 
	{
		while(true)
		{
			spinners++;
		
			if(paragraph >= 19)
			{
				pellets.get(0).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				pellets.get(1).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				pellets.get(2).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				pellets.get(3).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				pellets.get(4).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				
				for (int i = 0; i < pellets.size() * 10; i++)
				{
					if(countMove % 150 == 0 && countMove > 1000)
					{
						pellets.get(0).setLocation(pellets.get(0).getX() + 3, pellets.get(0).getY() + pellets.size() + 1);
						pellets.get(1).setLocation(pellets.get(1).getX() + 2, pellets.get(1).getY() + pellets.size() + 2);
						pellets.get(2).setLocation(pellets.get(2).getX() + 1, pellets.get(2).getY() + pellets.size() + 3);
						pellets.get(3).setLocation(pellets.get(3).getX() - 2, pellets.get(3).getY() + pellets.size() + 2);
						pellets.get(4).setLocation(pellets.get(4).getX() - 3, pellets.get(4).getY() + pellets.size() + 1);
					}
					countMove++;
				} //end of for loop
			}
			

			if(upsideDown == false && die == false)	// checks if pellets are upside down.  if true, flip them
			{
				pellets.get(0).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath)));
				pellets.get(1).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath)));
				pellets.get(2).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath)));
				pellets.get(3).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath)));
				pellets.get(4).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath)));
			}
			

			/** MOVES THE HEART DEPENDING ON WHAT ARROW KEY IS PRESSED **/
			if(rightPressed)	// if various keys are pressed, move the heart
			{
				heart.setLocation(heart.getX() + 2, heart.getY());
			}
			
			if(leftPressed)
			{
				heart.setLocation(heart.getX() - 2, heart.getY());
			}
			
			if(upPressed)
			{
				heart.setLocation(heart.getX(), heart.getY() - 2);
			}
			
			if(downPressed)
			{
				heart.setLocation(heart.getX(), heart.getY() + 2);
			}
			
			
			/** BIG OUCHY IF STATEMENT THAT GETS THE NEXT LINE FROM TEXTBOX - CODED BY ALDEN **/
			if (count > 3 * skip && num < textBox.get(line).length())	// if statements to get which dialogue to print out
			{	
				
				string1p2 = textBox.get(line).substring(0, num + 1);
				text.get(line).setText(string1p2);				
				count = 0;
				
				if (textBox.get(line).charAt(num) == ' ' && num > 13)
				{
						textBox.add(textBox.get(line).substring(num + 1, textBox.get(line).length()));
						
						
						if (textBox.get(line).charAt(num - 1) == ',' || textBox.get(line).charAt(num - 1) == '!' || textBox.get(line).charAt(num - 1) == '.' || textBox.get(line).charAt(num - 1) == '?' )
						{
							count -= 15 * skip;
						}
						
						line++;
						num = 0;
				}
				
				if (count % 4 == 0)
				{
					spin = !spin;
				}
				
				if (num > 0)
				{
					if (textBox.get(line).charAt(num - 1) == ',' || textBox.get(line).charAt(num - 1) == '!' || textBox.get(line).charAt(num - 1) == '.' || textBox.get(line).charAt(num - 1) == '?')
					{
						count -= 15 * skip;
					}
				}
				
				num++;
				
				if (skip != 0 && angry == false)
				{
					audioClips.loop(1);
				}
				
				if(skip != 0 && angry == true)
				{
					if(paragraph >= 14)
					{
						bubble.setVisible(true);
						audioEvil.start();
						audioEvil.loop(1);
					}
				}
				
			}
			else if (count > 5 * skip)
			{
				finished = true;
			}
			
			
			/** PAUSES THE PROGRAM **/
			count++;
			Thread.sleep(10);	// pauses slightly before each dialogue
			
			
			/** CHANGES FLOWEY'S ICON BACK TO IT'S ORIGINAL FORM **/
			if (!wink && paragraph < 16)	// sets the different image of flowey 
			{
				if (num % 4 == 0)
				{
					if(die == false)
					flowey.setIcon(new ImageIcon(TutorialFight.class.getResource(path1)));
				}
				else if (num % 4 == 2)
				{
					if(die == false)
					flowey.setIcon(new ImageIcon(TutorialFight.class.getResource(path2)));
				}
			}
			
			
			/** MOVES PELLETS ON-SCREEN **/
			if (wink  == true)	// animation to move pellets onscreen
			{
				if (movePellets < 50)
				{
					for (int i = 0; i < pellets.size(); i++)
					{
						
						if (i < pellets.size() / 2)
						{
							pellets.get(i).setLocation(pellets.get(i).getX() + i - pellets.size() / 2, pellets.get(i).getY() + pellets.size() - i - 1);
						}
						else
						{
							pellets.get(i).setLocation(pellets.get(i).getX() + i - pellets.size() / 2, pellets.get(i).getY() + i);
						}
					}//end of for loop
					movePellets++;
				}
				
			}
			
			
			/** CODE FOR THE MOVING OF THE PELLETS **/
			if(paragraph == 14 || paragraph == 15) // animation of the pellets gaining on the user
			{				
				if(paragraph == 15 && relocate == false)
				{
					audioClip.stop();
					audioSlow.start();
					pellets.get(0).setLocation(206,150);
					pellets.get(1).setLocation(256,100);
					pellets.get(2).setLocation(306,50);
					pellets.get(3).setLocation(356,100);
					pellets.get(4).setLocation(406,150);
					relocate = true;
				}

				if (movePellets2 < 1000)
				{
					for (int i = 0; i < pellets.size() * 10; i++)
					{
						if(countMove % 150 == 0 && countMove > 1000)
						{
							pellets.get(0).setLocation(pellets.get(0).getX() + 3, pellets.get(0).getY() + pellets.size() + 1);
							pellets.get(1).setLocation(pellets.get(1).getX() + 2, pellets.get(1).getY() + pellets.size() + 2);
							pellets.get(2).setLocation(pellets.get(2).getX() + 1, pellets.get(2).getY() + pellets.size() + 3);
							pellets.get(3).setLocation(pellets.get(3).getX() - 2, pellets.get(3).getY() + pellets.size() + 2);
							pellets.get(4).setLocation(pellets.get(4).getX() - 3, pellets.get(4).getY() + pellets.size() + 1);
						}
						countMove++;
					} //end of for loop
										
					
					movePellets2++;
				}
								
			}
			
			if(paragraph == 16)
			{
				flowey.setIcon(new ImageIcon(TutorialFight.class.getResource(trollflowey)));
				audioSlow.stop();
				die = true;
			}
				
			/** YOU SPIN MY HEAD RIGHT ROUND BABY RIGHT ROUND **/
			if(spinners % 10 == 0)		// if pellets are not upside down, flip them	
			{
				if(die == false)
				{
					pellets.get(0).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
					pellets.get(1).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
					pellets.get(2).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
					pellets.get(3).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
					pellets.get(4).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
					
					if(upsideDown == true)
					{
						upsideDown = false;
					}
					
					else if(upsideDown == false)
					{
						upsideDown = true;
					}
				}
			}
			
						
			/** IF YOU TOUCH A PELLET YOU DIE, SIR **/
			if(heart.getBounds().intersects(pellets.get(0).getBounds()) || heart.getBounds().intersects(pellets.get(1).getBounds()) || heart.getBounds().intersects(pellets.get(2).getBounds())  || heart.getBounds().intersects(pellets.get(3).getBounds()) || heart.getBounds().intersects(pellets.get(4).getBounds()))
			{
				if(die == false)	// if the heart touches the pellets, make them invisible
				{
					die = true;
					angry = true;
					healthBar.setIcon(new ImageIcon(TutorialFight.class.getResource(healthlink)));
					
					audioClipHit.start();
					audioClip.stop();
					audioSlow.stop();
										
					bubble.setVisible(false);
					audioClips.stop();
					paragraph = 16;
										
					pellets.get(0).setIcon(new ImageIcon(TutorialFight.class.getResource(blank)));
					pellets.get(1).setIcon(new ImageIcon(TutorialFight.class.getResource(blank)));
					pellets.get(2).setIcon(new ImageIcon(TutorialFight.class.getResource(blank)));
					pellets.get(3).setIcon(new ImageIcon(TutorialFight.class.getResource(blank)));
					pellets.get(4).setIcon(new ImageIcon(TutorialFight.class.getResource(blank)));
					flowey.setIcon(new ImageIcon(TutorialFight.class.getResource(trollflowey)));
					Thread.sleep(25);
					
					/*for (int x = 0; x < 5; x++)	// adds the arraylist of pellets
					{
						pellets.get(x).removeAll();
					}*/
					
				}
				
			}
			
			if(paragraph >= 19)
			{
				pellets.get(0).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				pellets.get(1).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				pellets.get(2).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				pellets.get(3).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				pellets.get(4).setIcon(new ImageIcon(TutorialFight.class.getResource(pelletpath2)));
				
				for (int i = 0; i < pellets.size() * 10; i++)
				{
					if(countMove % 150 == 0 && countMove > 1000)
					{
						pellets.get(0).setLocation(pellets.get(0).getX() + 3, pellets.get(0).getY() + pellets.size() + 1);
						pellets.get(1).setLocation(pellets.get(1).getX() + 2, pellets.get(1).getY() + pellets.size() + 2);
						pellets.get(2).setLocation(pellets.get(2).getX() + 1, pellets.get(2).getY() + pellets.size() + 3);
						pellets.get(3).setLocation(pellets.get(3).getX() - 2, pellets.get(3).getY() + pellets.size() + 2);
						pellets.get(4).setLocation(pellets.get(4).getX() - 3, pellets.get(4).getY() + pellets.size() + 1);
					}
					countMove++;
				} //end of for loop
			}
			
			
			/** TOUCHING THE BORDER = NO GO **/
			if(heart.getBounds().intersects(left.getBounds()))
			{
				leftPressed = false;
			}
			
			if(heart.getBounds().intersects(up.getBounds()))
			{
				upPressed = false;
			}
			if(heart.getBounds().intersects(right.getBounds()))
			{
				rightPressed = false;
			}
			if(heart.getBounds().intersects(down.getBounds()))
			{
				downPressed = false;
			}
			
		} // end while
	
	} // end object
	};
	
	
		/** IF YA MOVE YA KEYS **/
		class keyListener implements KeyListener
		{
		public void keyPressed(KeyEvent e) // checks if use pressed right, left, up, or down arrow keys
		{
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					rightPressed = true;
				}
				
				if(e.getKeyCode() == KeyEvent.VK_LEFT )
				{
					leftPressed = true;
				}
				
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					upPressed = true;	
				}
				
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					downPressed = true;
				}
				
				
				/** GOES THROUGH DIALOGUE **/
		  		if(e.getKeyCode() == KeyEvent.VK_Z || e.getKeyCode() == KeyEvent.VK_ENTER)	// dialogue
				{
					if (finished == true && (wink == false || count > 100))
					{
						finished = false;	// checks if dialogue is done yet
						num = 0;
						paragraph++;
						line = 0;
						
						if (wink == true)	// if pellet animation starts 
						{
							wink = false;
							bubble.setVisible(true);
						}
						
						if(paragraph == 10)	// changes flowey's icon for animation
						{
							bubble.setVisible(false);
							wink = true;
							if(die == false)
								flowey.setIcon(new ImageIcon(TutorialFight.class.getResource(path3)));
							fire = true;
						}
						if (paragraph == 11)	// ends the animation
						{
							wink = false;
						}
						
						for(int x = 0; x < text.size(); x++)	// sets text to blank string once dialogue string is done
						{
							text.get(x).setText("");
						}
						
						textBox.clear();
						
						textBox.add(allTheText.get(paragraph));	// prints out the text
						System.out.println(paragraph);
					}
					else
					{
					}
				}
		}

		/** STOPS MOVEMENT **/
		@Override
		public void keyReleased(KeyEvent e)	// when the key is released, heart movement ceases
		{
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				rightPressed = false;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				leftPressed = false;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				upPressed = false;	
			}
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				downPressed = false;
			}
			
		}

		/** DOES NOTHING IT IS JUST REQUIRED TO BE PUT HERE FOR KEYLISTENER TO WORK **/
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		
		}
		}
}