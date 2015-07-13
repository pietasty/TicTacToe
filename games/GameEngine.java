package games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import constants.*;

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
	
	private final static String PLAYERONEWIN = "Player 1 Wins!";
	private final static String PLAYERTWOWIN = "Player 2 Wins!";
	private final static String COMPUTERWIN = "The Computer Wins!";
	
	private GamePanel gamePanel;
	private List<GridPanel> gridPanels;
	
	private Timer timer;
	private List<Boolean> circles;
	private List<Boolean> crosses;
	private Boolean newGame;
	
	private OptionsPanel optionsPanel;
	
	private GameState gameState;
	private Difficulty difficulty;
	private PlayerOneToken token;
	
	public GameEngine(GamePanel gamePanel){
		optionsPanel = new OptionsPanel();
		
		this.gamePanel = gamePanel;
		gridPanels = gamePanel.getGridPanels();
		
		circles = new ArrayList<Boolean>();
		crosses = new ArrayList<Boolean>();
		newGame = false;
		
		timer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(newGame){
					newGame();
				}
				
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
				//Player with Crosses wins!
				for(Integer[] i : WINCONDITION){
					if(checkCross.containsAll(Arrays.asList(i))){
						String s;
						if(token == PlayerOneToken.CROSS){
							s = PLAYERONEWIN;
						} else {
							if(gameState == GameState.TWOPLAYER){
								s = PLAYERTWOWIN;
							} else {
								s = COMPUTERWIN;
							}
						}
						JOptionPane.showMessageDialog(null,
								s,"Winner!", JOptionPane.INFORMATION_MESSAGE);
						newGame = true;
					}
				}
				
				List<Integer> checkCircle = new ArrayList<Integer>();
				for(int i = 0; i<9;i++){
					if(circles.get(i)){
						checkCircle.add(i);
					}
				}
				//Player with Circles wins!
				for(Integer[] i : WINCONDITION){
					if(checkCircle.containsAll(Arrays.asList(i))){
						String s;
						if(token == PlayerOneToken.CIRCLE){
							s = PLAYERONEWIN;
						} else {
							if(gameState == GameState.TWOPLAYER){
								s = PLAYERTWOWIN;
							} else {
								s = COMPUTERWIN;
							}
						}
						JOptionPane.showMessageDialog(null,
								s,"Winner!", JOptionPane.INFORMATION_MESSAGE);
						newGame = true;
					}
				}
				
				//When a Draw happens!
				if((checkCross.size() + checkCircle.size()) == 9){
					JOptionPane.showMessageDialog(null,
							"It was a Draw!","Draw!", JOptionPane.INFORMATION_MESSAGE);
					newGame = true;
				}
			
			}
		});
		timer.start();
		
	}
	
	
	public void newGame(){
		timer.stop();
		newGame = false;
		for(GridPanel gP: gridPanels){
			gP.clearBoard();
			gP.setGameState(gameState);
			gP.setToken(token);
		}
		timer.start();
	}
	
	public void displayOptions(){
		String[] options = {"Start!","Cancel!"};
		int n = JOptionPane.showOptionDialog(null, optionsPanel, "Options", JOptionPane.YES_NO_OPTION, 
				JOptionPane.NO_OPTION, null, options, options[0]);
		if(n == 0){
			gameState = optionsPanel.gameState();
			difficulty = optionsPanel.whatDifficulty();
			token = optionsPanel.whatToken();
			
			newGame();
		}
	}
}
