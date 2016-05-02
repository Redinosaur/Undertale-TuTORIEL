package UselessPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
import javax.swing.SwingWorker;

import java.awt.Font;

import javax.swing.SwingConstants;


public class testing123 {
	String string1 = new String("Howdy, I'm FLOWEY! FLOWEY the FLOWER! ");
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



	String path1 = new String("/images/flowey1.png");
	String path2 = new String("/images/flowey1p2.png");
	String path3 = new String("/images/flowey1la.png");

	String pelletpath = new String("/images/pelletother.png"); // laying down
	String pelletpath2 = new String("/images/pellet.png"); // upside down

	String string1p2 = new String();
	
	boolean rightPressed = false;
	boolean leftPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;
	boolean talking = false;
	private boolean finished = false;
	boolean wink = false;
	
	private ArrayList <String> textBox = new ArrayList <String> ();
	private ArrayList <String> allTheText = new ArrayList <String> ();
	private ArrayList <JLabel> text = new ArrayList <JLabel> ();
	private ArrayList <JLabel> pellets = new ArrayList <JLabel> ();
	int count = 0, num = 0, count2 = 0, num2 = 0, line = 0, skip = 1;
	private int paragraph = 9;
	private int movePellets,movePellets2 = 0;
	boolean fire = false;
	boolean spin = false;
		
	String bip  = "/songs/flowey.wav";
	Clip audioClips;
	
	ImageIcon floweyI1 = new ImageIcon(path1);
	ImageIcon floweyI2 = new ImageIcon(path2);
	
	private JFrame frame;
	JLabel heart;
	JLabel text2;
	JLabel texts;
	JLabel flowey;
	JLabel bubble;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testing123 window = new testing123();
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
	public testing123() 
	{
		initialize();
		movePlayer.execute();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		/*while (in.hasNext())
		{
			allTheText.add(in.nextLine());
		}*/
		allTheText.add(string1);
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
		
		textBox.add(allTheText.get(paragraph));
		
		frame = new JFrame();
		frame.addKeyListener(new keyListener());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel healthBar = new JLabel("New label");
		healthBar.setIcon(new ImageIcon(testing123.class.getResource("/images/health11.png")));
		healthBar.setBounds(195, 375, 257, 42);
		frame.getContentPane().add(healthBar);
		
		JLabel dialogue = new JLabel("");
		dialogue.setIcon(new ImageIcon(testing123.class.getResource("/images/white1.png")));
		dialogue.setBounds(229, 216, 178, 161);
		frame.getContentPane().add(dialogue);
		
		flowey = new JLabel("");
		flowey.setIcon(new ImageIcon(testing123.class.getResource("/images/flowey1.png")));
		flowey.setBounds(270, 61, 96, 126);
		frame.getContentPane().add(flowey);
		
		for (int x = 0; x < 5; x++)
		{
			JLabel pellet = new JLabel("");
			pellet.setIcon(new ImageIcon(testing123.class.getResource("/images/pellet.png")));
			pellet.setBounds(306, -50, 21, 23);
			frame.getContentPane().add(pellet);
			pellets.add(pellet);
		}
		
		heart = new JLabel("  ");
		heart.setIcon(new ImageIcon(testing123.class.getResource("/images/grgrgrgr.png")));
		heart.setBounds(306, 325, 21, 23);
		frame.getContentPane().add(heart);
		
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
		
		bubble = new JLabel("  ");
		bubble.setForeground(Color.BLACK);
		bubble.setBackground(Color.WHITE);
		bubble.setIcon(new ImageIcon(testing123.class.getResource("/images/bubble2.png")));
		bubble.setBounds(376, 60, 246, 127);
		frame.getContentPane().add(bubble);
		bubble.setText("test");
		frame.setBounds(100, 100, 648, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		String bip = new String();
		bip = "Resource/songs/mus_flowey.wav";
		String bipper  = "Resource/songs/floweyTalk.wav";
		
		File audioFile = new File(bip);
		System.out.println(audioFile.getAbsolutePath());
		
		AudioInputStream audioStream;
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip audioClip;
			try {
				audioClip = (Clip) AudioSystem.getLine(info);
				audioClip.open(audioStream);
				audioClip.start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
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
			
		}catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	SwingWorker<Object, Object> movePlayer = new SwingWorker<Object, Object>()
	{
	@Override 
	protected Object doInBackground() throws Exception 
	{
		while(true)
		{
			
			if (wink  == true)
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
						Thread.sleep(3);
					}//end of for loop
					movePellets++;
				}
			}
			
			if(rightPressed)
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
			
			if (count > 5 * skip && num < textBox.get(line).length())
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
				
				if (skip != 0)
				{
					audioClips.loop(1);
				}
			}
			else if (count > 5 * skip)
			{
				finished = true;
			}
			
			count++;
			Thread.sleep(20);
			if (!wink)
			{
				if (num % 4 == 0)
				{
					flowey.setIcon(new ImageIcon(testing123.class.getResource(path1)));
				}
				else if (num % 4 == 2)
				{
					flowey.setIcon(new ImageIcon(testing123.class.getResource(path2)));
				}
			}
			
			for (int x = 0; x < pellets.size(); x++)
			{
				if (spin)
				{
					pellets.get(x).setIcon(new ImageIcon(testing123.class.getResource(pelletpath)));
				}
				else
				{
					pellets.get(x).setIcon(new ImageIcon(testing123.class.getResource(pelletpath2)));
				}
			}
			
			if(paragraph == 14)
			{
				if (movePellets2 < 50)
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
					
					} //end of for loop
					
					movePellets2++;
				}
			}
			
		} // end while
	
	} // end object
	};
	
		class keyListener implements KeyListener
		{
		public void keyPressed(KeyEvent e)
		{
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					rightPressed = true;
				}
				
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
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
				
		  		if(e.getKeyCode() == KeyEvent.VK_Z || e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if (finished == true && (wink == false || count > 100))
					{
						finished = false;
						num = 0;
						paragraph++;
						line = 0;
						skip = 1;
						
						if (wink == true)
						{
							wink = false;
							bubble.setVisible(true);
						}
						
						if(paragraph == 10)
						{
							bubble.setVisible(false);
							wink = true;
							flowey.setIcon(new ImageIcon(testing123.class.getResource(path3)));
							fire = true;
						}
						if (paragraph == 11)
						{
							wink = false;
						}
						
						for(int x = 0; x < text.size(); x++)
						{
							text.get(x).setText("");
						}
						
						textBox.clear();
						
						textBox.add(allTheText.get(paragraph));
						System.out.println(paragraph);
					}
					else
					{
						skip = 0;
					}
				}
		}

		@Override
		public void keyReleased(KeyEvent e)
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

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}
}



	

