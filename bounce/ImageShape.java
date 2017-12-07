package bounce;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class to represent an image.
 * 
 * @author Abby Shen
 * 
 */
public class ImageShape extends Shape {
	private BufferedImage _image = null;

	/**
	 * Default constructor that creates a ImageShape instance whose instance
	 * variables are set to default values.
	 */
	public ImageShape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TEXT);
	}
	
	public ImageShape(String text) {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);
	}
	
	/**
	 * Creates a ImageShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 */
	public ImageShape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TEXT);
	}
	
	public ImageShape(int x, int y, String text) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);
	}

	/**
	 * Creates a ImageShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public ImageShape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_TEXT);
	}
	
	public ImageShape(int x, int y, int deltaX, int deltaY, String text) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);
	}

	/**
	 * Creates a ImageShape instance with specified values for instance 
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
	public ImageShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		this(x, y, deltaX, deltaY, width, height, DEFAULT_TEXT);
	}
	
	public ImageShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
		try {
			_image = ImageIO.read(new File("src/JavaIcon.JPG"));
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}

	/**
	 * Paints this ImageShape object using the supplied Painter object.
	 */
	protected void paintShape(Painter painter) {
		painter.drawImage(_image,_x,_y,DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}