package games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameMenu extends JMenuBar{
	
	private JMenu game;
	private JMenu help;
	
	private GameEngine gameEngine;
	
	public GameMenu(GameEngine gE){
		addGameMenu();
		addHelpMenu();
		gameEngine = gE;
		
	}
	
	private void addGameMenu(){
		game = new JMenu("Game");
		game.setMnemonic(KeyEvent.VK_G);
		add(game);
		
		
		JMenuItem newGame = new JMenuItem("New Game",KeyEvent.VK_F2);
		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gameEngine.newGame();
			}
	
		});
		game.add(newGame);
		
		game.addSeparator();
		
		
		JMenuItem statistics = new JMenuItem("Statistics", KeyEvent.VK_F4);
		statistics.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO
			}
	
		});
		game.add(statistics);
		
		
		JMenuItem options = new JMenuItem("Options", KeyEvent.VK_F5);
		options.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gameEngine.displayOptions();
			}
	
		});
		game.add(options);
		
		game.addSeparator();
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO
			}
	
		});
		game.add(exit);
	}
	
	//TODO
	private void addHelpMenu(){
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		add(help);
		
	}
	
}
