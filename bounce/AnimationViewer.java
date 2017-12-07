package bounce;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * Simple GUI program to show an animation of shapes. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimised, and maximised. The state of an
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Shapes requesting that each Shape paints and moves itself.
 * 
 * @author Ian Warren
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Shapes to animate.
	private List<Shape> _shapes;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Shape objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		_shapes = new ArrayList<Shape>();
	
		// Populate the list of Shapes.
		_shapes.add(new RectangleShape(3, 96, 52, 0));
		_shapes.add(new RectangleShape(100, 10, 5, 7));
		
		/**
		 * @author Abby Shen
		 */
		NestingShape root = new NestingShape(100, 100, 8, -4, 450, 400, "hi");
		NestingShape nested = new NestingShape(30, 100, 8, 5, "Friday");
		NestingShape intermediate = new NestingShape(0, 0, 11, 3, 250, 350);
		
		_shapes.add(root);
		_shapes.add(new OvalShape("Hello world, I am an oval!"));
		_shapes.add(new OvalShape(5, 8, 4, 14));
		_shapes.add(new GemShape(20, 75, 3, 8, 35, 25));
		_shapes.add(new DynamicRectangleShape(40, 0, 19, 17, Color.BLUE, "Rect"));
		_shapes.add(new ImageShape(80, 50, "image"));
		
		root.add(new GemShape(12, 6, -2, 1, 85, 55));
		root.add(new OvalShape(12, 3, 2, 4, "Hello World"));
		root.add(new ImageShape(20, 40, 5, 2, "I am an image with text"));
		root.add(nested);
		root.add(intermediate);
		
		nested.add(new DynamicRectangleShape(0, 0, 6, 2, 15, 5));
		intermediate.add(new OvalShape(5, 8, 4, 4, 20, 20));
		intermediate.add(new GemShape(12, 6, 2, 3, 25, 55, "BOUNCE"));
		intermediate.add(new DynamicRectangleShape(Color.PINK, "2"));
		intermediate.add(new DynamicRectangleShape(14, 8, Color.CYAN));
		intermediate.add(new DynamicRectangleShape(2, 0, 2, 0, Color.YELLOW));
		intermediate.add(new DynamicRectangleShape(20, 20, -2, 6, 20, 20, Color.BLUE));
		intermediate.add(new DynamicRectangleShape(12, 9, 7, 9, 20, 20, "1", Color.GREEN));
			
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Shape objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Shape s : _shapes) {
			s.paint(painter);
			s.move(width, height);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}
	
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
