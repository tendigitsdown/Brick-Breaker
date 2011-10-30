import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This program creates a five-pointed start every time the user
 * clicks the mouse on the canvas. -- DEPRECATED --
 * 
 * NEW FUNCTIONALITY -- onClick displays mouse coordinates in a GLabel
 * 
 * @author sachingoel
 */

public class StarMaker extends GraphicsProgram {

/* Initializes the mouse listeners */
	public void init() {
		addMouseListeners();
	}
	
/* Called whenever the user clicks the mouse */
	public void mouseClicked(MouseEvent e) {
		GLabel coords = new GLabel("(" + e.getX() + ", " + e.getY() + ")");
		add(coords, e.getX(), e.getY());
	}
/* Private constants */
	private static final int STAR_SIZE = 20;
	
}
