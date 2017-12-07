package bounce;

/**
 * Class to represent a gem.
 * 
 * @author Abby Shen
 * 
 */
public class GemShape extends Shape {
	/**
	 * Default constructor that creates a GemShape instance whose instance
	 * variables are set to default values.
	 */
	public GemShape() {
		super();
	}
	
	public GemShape(String text) {
		super(text);
	}
	
	/**
	 * Creates a GemShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 */
	public GemShape(int x, int y) {
		super(x,y);
	}
	
	public GemShape(int x, int y, String text) {
		super(x,y,text);
	}
	
	/**
	 * Creates a GemShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public GemShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	public GemShape(int x, int y, int deltaX, int deltaY, String text) {
		super(x,y,deltaX,deltaY,text);
	}
	
	/**
	 * Creates a GemShape instance with specified values for instance 
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
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	/**
	 * Paints this GemShape object using the supplied Painter object.
	 */
	protected void paintShape(Painter painter) {
		//(x,y) coordinates of vertices, clockwise from top-left
		int[] x = new int[6];
		int[] y = new int[6];
		boolean isSmallGem = _width < 40;

		x[0] = isSmallGem ? _x + Math.round(_width/2) : _x + 20;
		x[1] = isSmallGem ? x[0] : _x + _width-20;
		x[2] = _x + _width;
		x[3] = x[1];
		x[4] = x[0];
		x[5] = _x;

		y[0] = _y;
		y[1] = y[0];
		y[2] = _y + Math.round(_height/2);
		y[3] = _y + _height;
		y[4] = y[3];
		y[5] = y[2];

		for (int i=0; i<6; i++) {
			painter.drawLine(x[i], y[i], x[(i+1) %6], y[(i+1) %6]);
		}
	}
}