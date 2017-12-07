package bounce;
import java.awt.Color;

/**
 * Class to represent a dynamic rectangle.
 * 
 * @author Abby Shen
 * 
 */
public class DynamicRectangleShape extends Shape {
	private Color currentColour = Color.BLACK;
	
	/**
	 * Default constructor that creates a DynamicRectangleShape instance whose instance
	 * variables are set to default values.
	 */
	public DynamicRectangleShape() {
		super();
	}
	
	public DynamicRectangleShape(String text) {
		super(text);
	}
	
	/**
	 * Above constructor but with an additional java.awt.Color argument
	 * @param colour supplied java.awt.Color
	 */
	public DynamicRectangleShape(Color colour) {
		this();
		currentColour = colour;
		_bouncedOff = Edge.LEFT;
	}
	
	public DynamicRectangleShape(Color colour, String text) {
		this(text);
		currentColour = colour;
		_bouncedOff = Edge.LEFT;
	}
	
	/**
	 * Creates a DynamicRectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 */
	public DynamicRectangleShape(int x, int y) {
		super(x,y);
	}
	
	public DynamicRectangleShape(int x, int y, String text) {
		super(x,y,text);
	}
	
	/**
	 * Above constructor but with an additional java.awt.Color argument
	 * @param colour supplied java.awt.Color
	 */
	public DynamicRectangleShape(int x, int y, Color colour) {
		this(x,y);
		currentColour = colour;
		_bouncedOff = Edge.LEFT;
	}
	
	public DynamicRectangleShape(int x, int y, Color colour, String text) {
		this(x,y,text);
		currentColour = colour;
		_bouncedOff = Edge.LEFT;
	}
	
	/**
	 * Creates a DynamicRectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, String text) {
		super(x,y,deltaX,deltaY,text);
	}
	
	/**
	 * Above constructor but with an additional java.awt.Color argument
	 * @param colour supplied java.awt.Color
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color colour) {
		this(x,y,deltaX,deltaY);
		currentColour = colour;
		_bouncedOff = Edge.LEFT;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color colour, String text) {
		this(x,y,deltaX,deltaY,text);
		currentColour = colour;
		_bouncedOff = Edge.LEFT;
	}
	
	/**
	 * Creates a DynamicRectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	/**
	 * Above constructor but with an additional java.awt.Color argument
	 * @param colour supplied java.awt.Color
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color colour) {
		this(x,y,deltaX,deltaY,width,height);
		currentColour = colour;
		_bouncedOff = Edge.LEFT;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color colour) {
		this(x,y,deltaX,deltaY,width,height,text);
		currentColour = colour;
		_bouncedOff = Edge.LEFT;
	}
	
	/**
	 * Paints this DynamicRectangleShape object using the supplied Painter object.
	 */
	protected void paintShape(Painter painter) {
		if (_bouncedOff==Edge.LEFT || _bouncedOff==Edge.RIGHT || _bouncedOff==Edge.TOPLEFT || _bouncedOff==Edge.TOPRIGHT ||_bouncedOff==Edge.BOTTOMLEFT || _bouncedOff==Edge.BOTTOMRIGHT) {
			painter.fillRect(_x,_y,_width,_height,currentColour); //If it bounces off both walls, the vertical wall determines its appearance
		} else {
			painter.drawRect(_x,_y,_width,_height);
		}
	}
}