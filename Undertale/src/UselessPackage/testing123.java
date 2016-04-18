package UselessPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;


public class testing123 {
	
	boolean rightPressed = false;
	boolean leftPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;
	
	String bip  = "/songs/flowey.wav";

	private JFrame frame;
	JLabel heart;

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
	public testing123() {
		initialize();
		movePlayer.execute();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addKeyListener(new keyListener());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel dialogue = new JLabel("");
		dialogue.setIcon(new ImageIcon(testing123.class.getResource("/images/white1.png")));
		dialogue.setBounds(229, 216, 178, 161);
		frame.getContentPane().add(dialogue);
		
		JLabel flowey = new JLabel("");
		flowey.setIcon(new ImageIcon(testing123.class.getResource("/images/flowey1.png")));
		flowey.setBounds(270, 61, 96, 126);
		frame.getContentPane().add(flowey);
		
		JLabel pellet = new JLabel("");
		pellet.setIcon(new ImageIcon(testing123.class.getResource("/images/pellet.png")));
		pellet.setBounds(219, 96, 21, 23);
		frame.getContentPane().add(pellet);
		
		JLabel bubble = new JLabel("  ");
		bubble.setBackground(Color.WHITE);
		bubble.setIcon(new ImageIcon(testing123.class.getResource("/images/bubble.png")));
		bubble.setBounds(376, 60, 209, 127);
		frame.getContentPane().add(bubble);
		
		heart = new JLabel("  ");
		heart.setIcon(new ImageIcon(testing123.class.getResource("/images/grgrgrgr.png")));
		heart.setBounds(306, 325, 21, 23);
		frame.getContentPane().add(heart);
		frame.setBounds(100, 100, 648, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
	
	SwingWorker<Object, Object> movePlayer = new SwingWorker<Object, Object>()
	{
	@Override 
	protected Object doInBackground() throws Exception 
	{
		while(true)
		{
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
			Thread.sleep(16);
		}
	
	}
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



	

