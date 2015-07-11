package games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class GameEngine {
	
	private final static Integer[] WIN1 = {0,1,2};
	private final static Integer[] WIN2 = {3,4,5};
	private final static Integer[] WIN3 = {6,7,8};
	private final static Integer[] WIN4 = {0,3,6};
	private final static Integer[] WIN5 = {1,4,7};
	private final static Integer[] WIN6 = {2,5,8};
	private final static Integer[] WIN7 = {0,4,8};
	private final static Integer[] WIN8 = {2,4,6};
	
	private final static Integer[][] WINCONDITION = {
		WIN1,WIN2,WIN3,WIN4,WIN5,WIN6,WIN7,WIN8
	};
	
	private GamePanel gamePanel;
	private GameMenu gameMenu;
	private List<GridPanel> gridPanels;
	
	private Timer timer;
	private List<Boolean> circles;
	private List<Boolean> crosses;
	
	public GameEngine(GamePanel gamePanel, GameMenu gameMenu){
		this.gamePanel = gamePanel;
		this.gameMenu = gameMenu;
		gridPanels = gamePanel.getGridPanels();
		
		circles = new ArrayList<Boolean>();
		crosses = new ArrayList<Boolean>();
		
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e){
				for(int i = 0; i<9; i++){
					circles.add(i, gridPanels.get(i).getCircle());
					crosses.add(i, gridPanels.get(i).getCross());
				}
				List<Integer> checkCross = new ArrayList<Integer>();
				for(int i = 0; i<9;i++){
					if(crosses.get(i)){
						checkCross.add(i);
					}
				}
				for(Integer[] i : WINCONDITION){
					if(checkCross.containsAll(Arrays.asList(i))){
						JOptionPane.showMessageDialog(null,
								"Player 1 wins!","Winner!", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				List<Integer> checkCircle = new ArrayList<Integer>();
				for(int i = 0; i<9;i++){
					if(circles.get(i)){
						checkCircle.add(i);
					}
				}
				for(Integer[] i : WINCONDITION){
					if(checkCircle.containsAll(Arrays.asList(i))){
						JOptionPane.showMessageDialog(null,
								"Player 2 wins!","Winner!", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if((checkCross.size() + checkCircle.size()) == 9){
					JOptionPane.showMessageDialog(null,
							"It was a Draw!","Draw!", JOptionPane.INFORMATION_MESSAGE);
				}
			
			}
		});
		timer.start();
	}
	
	
	
}
