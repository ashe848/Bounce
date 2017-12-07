package bounce;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Ian Warren
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
	}

	/**
	 * @see bounce.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see bounce.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see bounce.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}
	
	/** 
	 * @author Abby Shen
	 */

	public void fillRect(int x, int y, int width, int height, Color colour) {
		_g.setColor(colour);
		_g.fillRect(x, y, width, height);
		_g.setColor(Color.BLACK);
	}

	public Color getColour() {
		return _g.getColor();
	}

	public void setColour(Color colour) {
		_g.setColor(colour);
	}
	
	public void translate(int x, int y) {
		_g.translate(x, y);
	}
	
	public void drawCentredText(int x, int y, String text) {
		if (text != null) {
			FontMetrics fontMetrics = _g.getFontMetrics();
			int stringWidth = fontMetrics.stringWidth(text);
			int x_middle = (int) (x - stringWidth / 2);
			int ascent = fontMetrics.getAscent();
			int descent = fontMetrics.getDescent();
			int y_middle = (int) (y + (ascent - descent) / 2);
			_g.drawString(text, x_middle, y_middle);
		}
	}

	public void drawImage(Image img, int x, int y, int width, int height) {
		_g.drawImage(img,x,y,width,height,null);
	}
}
