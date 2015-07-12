package games;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import event.ClickEvent;

public class GamePanel extends JPanel {
	
	private GridPanel topLeft;
	private GridPanel topMiddle;
	private GridPanel topRight;
	private GridPanel centerLeft;
	private GridPanel centerMiddle;
	private GridPanel centerRight;
	private GridPanel bottomLeft;
	private GridPanel bottomMiddle;
	private GridPanel bottomRight;
	
	private List<GridPanel> gridPanels;
	
	private Color borderColour;
	private int borderSize;
	
	public GamePanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.white);
		gridPanels = new ArrayList<GridPanel>();
		
		borderColour = Color.black;
		borderSize = 10;
		setPanels();
	}
	
	
	private void setPanels(){
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		borderSize /= 2;
		
		//Set top left panel
		topLeft = new GridPanel(this);
		topLeft.setBorder(BorderFactory.createMatteBorder(0, 0, borderSize, borderSize, borderColour));
		c.gridx = 0;
		c.gridy = 0;
		add(topLeft,c);
		gridPanels.add(topLeft);
		
		
		//Set top middle panel
		topMiddle = new GridPanel(this);
		topMiddle.setBorder(BorderFactory.createMatteBorder(0, borderSize, borderSize, borderSize, borderColour));
		c.gridx = 1;
		c.gridy = 0;
		add(topMiddle,c);
		gridPanels.add(topMiddle);
		
		
		//Set top right panel
		topRight = new GridPanel(this);
		topRight.setBorder(BorderFactory.createMatteBorder(0, borderSize, borderSize, 0, borderColour));
		c.gridx = 2;
		c.gridy = 0;
		add(topRight,c);
		gridPanels.add(topRight);
		
		
		//Set center left panel
		centerLeft = new GridPanel(this);
		centerLeft.setBorder(BorderFactory.createMatteBorder(borderSize, 0, borderSize, borderSize, borderColour));
		c.gridx = 0;
		c.gridy = 1;
		add(centerLeft,c);
		gridPanels.add(centerLeft);
		
		
		//Set center middle panel
		centerMiddle = new GridPanel(this);
		centerMiddle.setBorder(BorderFactory.createMatteBorder(borderSize, borderSize, borderSize, borderSize, borderColour));
		c.gridx = 1;
		c.gridy = 1;
		add(centerMiddle,c);
		gridPanels.add(centerMiddle);
		
		
		//Set center right panel
		centerRight = new GridPanel(this);
		centerRight.setBorder(BorderFactory.createMatteBorder(borderSize, borderSize, borderSize, 0, borderColour));
		c.gridx = 2;
		c.gridy = 1;
		add(centerRight,c);
		gridPanels.add(centerRight);
		
		
		//Set bottom left panel
		bottomLeft = new GridPanel(this);
		bottomLeft.setBorder(BorderFactory.createMatteBorder(borderSize, 0, 0, borderSize, borderColour));
		c.gridx = 0;
		c.gridy = 2;
		add(bottomLeft,c);
		gridPanels.add(bottomLeft);
		
		
		//Set bottom middle panel
		bottomMiddle = new GridPanel(this);
		bottomMiddle.setBorder(BorderFactory.createMatteBorder(borderSize, borderSize, 0, borderSize, borderColour));
		c.gridx = 1;
		c.gridy = 2;
		add(bottomMiddle,c);
		gridPanels.add(bottomMiddle);
		
		
		//Set bottom right panel
		bottomRight = new GridPanel(this);
		bottomRight.setBorder(BorderFactory.createMatteBorder(borderSize, borderSize, 0, 0, borderColour));
		c.gridx = 2;
		c.gridy = 2;
		add(bottomRight,c);
		gridPanels.add(bottomRight);
		
	}
	
	public List<GridPanel> getGridPanels(){
		return gridPanels;
	}
	
	public void notifyClickListeners(ClickEvent e){
		for(GridPanel gp : gridPanels){
			gp.clickOccurred(e);
		}
	}
}
