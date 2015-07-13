package games;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import constants.GameState;
import constants.PlayerOneToken;
import event.ClickEvent;
import event.ClickListener;

public class GridPanel extends JPanel implements MouseListener, ClickListener{
	
	private GamePanel gamePanel;
	
	private GameState gameState;
	private PlayerOneToken token;
	
	private boolean cross;
	private boolean circle;
	private boolean painted;
	private boolean check;
	
	public GridPanel(GamePanel gp){
		gamePanel = gp;
		cross = false;
		circle = false;
		painted = false;
		check = false;
		setBackground(Color.white);
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D)g;
		float thickness = 5;
		g2.setStroke(new BasicStroke(thickness));
		
		int x = getWidth()/2;
		int y = getHeight()/2;
		int r = x;
		if(cross){
			r = x/2;
			g2.drawLine(x-r, y-r, x+r, y+r);
			g2.drawLine(x+r, y-r, x-r, y+r);
		}
		x -= (r/2);
		y -= (r/2);
		if (circle){
			g2.drawOval(x, y, r, r);
		}
		
		if(check){
			if(token == PlayerOneToken.CIRCLE){
				cross = true;
			} else {
				cross = false;
			}
			check = false;
		}
	} 

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!painted){
			gamePanel.notifyClickListeners(new ClickEvent(cross,circle));
			repaint();
			painted = true;
		}
	}

	@Override
	public void clickOccurred(ClickEvent e) {
		if(!painted){
			boolean x = e.getCross();
			boolean o = e.getCircle();
			toggleToken(x,o);
		}
	}
	
	/**
	 * @return True if a Circle is painted
	 */
	public boolean getCircle(){
		if(painted){
			return circle;
		}
		return false;
	}
	
	/**
	 * @return True if a Cross is painted
	 */
	public boolean getCross(){
		if(painted){
			return cross;
		}
		return false;
	}
	
	public void clearBoard(){
		circle = false;
		cross = false;
		painted = false;
		repaint();
	}
	
	public void setGameState(GameState gS){
		gameState = gS;
	}
	
	public void setToken(PlayerOneToken t){
		token = t;
		check = true;
	}
	
	
	//----------------------------------------------------
	
	private void toggleToken(boolean x, boolean o){
		if(x){
			circle = true;
			cross = false;
		} else {
			cross = true;
			circle = false;
		}
	}
}
