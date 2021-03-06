package games;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import constants.*;

public class OptionsPanel extends JPanel{
	
	private JRadioButton onePlayer;
	private JRadioButton twoPlayers;
	
	private JPanel onePlayerStart;
	private JPanel onePlayerDifficulty;
	private JPanel twoPlayersStart;
	
	private JRadioButton easy;
	private JRadioButton hard;
	private JRadioButton impossible;
	
	private JRadioButton oneCircle;
	private JRadioButton oneCross;
	
	private JRadioButton twoCircle;
	private JRadioButton twoCross;
	
	
	private GridBagConstraints c;
	
	public OptionsPanel(){
		setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		setUpOnePlayer();
		setUpTwoPlayers();
		
		setUpInitialOptions();
	}
	
	private void setUpOnePlayer(){
		onePlayer = new JRadioButton("One Player");
		onePlayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onePlayer.setSelected(true);
				twoPlayers.setSelected(false);
				toggleOnePlayer(true);
			}
			
		});
		c.gridx = 0;
		c.gridy = 0;
		add(onePlayer,c);
		
		onePlayerDifficulty = new JPanel(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 1;
		add(onePlayerDifficulty, c);
		
		setUpDifficulty();
		
		onePlayerStart = new JPanel(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 2;
		add(onePlayerStart,c);
		
		setUpOneStart();
		
	}
	
	private void setUpDifficulty(){
		GridBagConstraints c1 = new GridBagConstraints();
		c1.weightx = 1;
		c1.weighty = 1;
		c1.fill = GridBagConstraints.BOTH;
		
		JTextField text = new JTextField("Choose the Difficulty!");
		text.setEditable(false);
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 3;
		onePlayerDifficulty.add(text, c1);
		
		easy = new JRadioButton("Easy");
		easy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				easy.setSelected(true);
				hard.setSelected(false);
				impossible.setSelected(false);
			}
		});
		c1.gridx = 0;
		c1.gridy = 1;
		c1.gridwidth = 1;
		onePlayerDifficulty.add(easy, c1);
		
		hard = new JRadioButton("Hard");
		hard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				hard.setSelected(true);
				easy.setSelected(false);
				impossible.setSelected(false);
			}
		});
		c1.gridx = 1;
		c1.gridy = 1;
		onePlayerDifficulty.add(hard, c1);
		
		impossible = new JRadioButton("Impossible");
		impossible.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				impossible.setSelected(true);
				hard.setSelected(false);
				easy.setSelected(false);
			}
		});
		c1.gridx = 2;
		c1.gridy = 1;
		onePlayerDifficulty.add(impossible, c1);
	}

	private void setUpOneStart(){
		GridBagConstraints c2 = new GridBagConstraints();
		c2.weightx = 1;
		c2.weighty = 1;
		c2.fill = GridBagConstraints.BOTH;
		
		JTextField text = new JTextField("Player 1's Token");
		text.setEditable(false);
		c2.gridx = 0;
		c2.gridy = 0;
		c2.gridwidth = 2;
		onePlayerStart.add(text, c2);
		
		oneCircle = new JRadioButton("Circle o");
		oneCircle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				oneCircle.setSelected(true);
				oneCross.setSelected(false);
			}
		});
		c2.gridx = 0;
		c2.gridy = 1;
		c2.gridwidth = 1;
		onePlayerStart.add(oneCircle, c2);
		
		oneCross = new JRadioButton("Cross x");
		oneCross.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				oneCross.setSelected(true);
				oneCircle.setSelected(false);
			}
		});
		c2.gridx = 1;
		c2.gridy = 1;
		onePlayerStart.add(oneCross, c2);
		
	}
	
	private void setUpTwoPlayers(){
		twoPlayers = new JRadioButton("Two Players");
		twoPlayers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				twoPlayers.setSelected(true);
				onePlayer.setSelected(false);
				toggleOnePlayer(false);
			}
			
		});
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0,10,0,0);
		add(twoPlayers,c);
		
		
		twoPlayersStart = new JPanel(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 1;
		add(twoPlayersStart,c);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.weightx = 1;
		c3.weighty = 1;
		c3.fill = GridBagConstraints.BOTH;
		
		JTextField text = new JTextField("Player 1's Token");
		text.setEditable(false);
		c3.gridx = 0;
		c3.gridy = 0;
		c3.gridwidth = 2;
		twoPlayersStart.add(text, c3);
		
		twoCircle = new JRadioButton("Circle o");
		twoCircle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				twoCircle.setSelected(true);
				twoCross.setSelected(false);
			}
		});
		c3.gridx = 0;
		c3.gridy = 1;
		c3.gridwidth = 1;
		twoPlayersStart.add(twoCircle, c3);
		
		twoCross = new JRadioButton("Cross x");
		twoCross.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				twoCross.setSelected(true);
				twoCircle.setSelected(false);
			}
		});
		c3.gridx = 1;
		c3.gridy = 1;
		twoPlayersStart.add(twoCross, c3);
	}
	
	private void setUpInitialOptions(){
		onePlayer.setSelected(true);
		hard.setSelected(true);
		oneCross.setSelected(true);
		twoCross.setSelected(true);
		toggleOnePlayer(true);
	}
	
	private void toggleOnePlayer(boolean b){
		easy.setEnabled(b);
		hard.setEnabled(b);
		impossible.setEnabled(b);
		oneCircle.setEnabled(b);
		oneCross.setEnabled(b);
		twoCircle.setEnabled(!b);
		twoCross.setEnabled(!b);
	}
	
	public GameState gameState(){
		if(onePlayer.isSelected()){
			return GameState.ONEPLAYER;
		}
		return GameState.TWOPLAYER;
	}
	
	public Difficulty whatDifficulty(){
		if(easy.isSelected()){
			return Difficulty.EASY;
		} else if (impossible.isSelected()){
			return Difficulty.IMPOSSIBLE;
		}
		return Difficulty.HARD;
	}
	
	public PlayerOneToken whatToken(){
		if (gameState() == GameState.ONEPLAYER){
			if(oneCross.isSelected()){
				return PlayerOneToken.CROSS;
			} 
			return PlayerOneToken.CIRCLE;
		}
		if(twoCross.isSelected()){
			return PlayerOneToken.CROSS;
		} 
		return PlayerOneToken.CIRCLE;
		
	}
}
