package UselessPackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class keyListen implements KeyListener
{

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int x = 0;
		int y = 0;
		
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			System.out.println("You went about right");
			x += 3;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			System.out.println("You went left");
			x -= 3;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			y += 3;
			System.out.println("You went up");	
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			y -= 3;
			System.out.println("You went down");	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}