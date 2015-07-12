package games;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame myFrame = new Main();
				myFrame.setVisible(true);
			}
		});

	}
	
	public Main() {
		super("LoL Tic Tac Toe");
		GamePanel gP = new GamePanel();
		this.setContentPane(gP);
		GameEngine gE = new GameEngine(gP);
		//GameMenu gM = new GameMenu();
		this.setJMenuBar(new GameMenu(gE));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
	}

}
