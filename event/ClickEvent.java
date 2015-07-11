package event;

public class ClickEvent {
	
	private boolean cross;
	private boolean circle;
	
	public ClickEvent(boolean cross, boolean circle){
		this.cross = cross;
		this.circle = circle;
	}
	
	public boolean getCross(){
		return cross;
	}
	
	public boolean getCircle(){
		return circle;
	}
}
