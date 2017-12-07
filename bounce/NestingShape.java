package bounce;

import java.util.ArrayList;
import java.util.List;

public class NestingShape extends Shape {
	
	private List<Shape> shapeList = new ArrayList<Shape>();

	public NestingShape() {
		super();
	}

	public NestingShape(String text) {
		super(text);
	}

	public NestingShape(int x, int y) {
		super(x, y);
	}

	public NestingShape(int x, int y, String text) {
		super(x, y, text);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY, String text) {
		super(x, y, deltaX, deltaY, text);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}

	public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x, y, deltaX, deltaY, width, height, text);
	}
	
	public void move(int width, int height) {
		super.move(width, height);
		for (Shape shape:shapeList) {
			shape.move(_width, _height);
		}
	}
	
	protected void paintShape(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		painter.translate(_x, _y);
		for (Shape shape:shapeList) {
			shape.paint(painter);
		}
		painter.translate(-_x, -_y);
	}
	
	void add(Shape shape) throws IllegalArgumentException {
		if (shape._parent != null || (shape._x+shape._width > this._width) || (shape._y+shape._height > this._height)) {
			throw new IllegalArgumentException();
		} else {
			shape._parent = this;
			shapeList.add(shape);
		}
	}

	void remove(Shape shape) {
		if (shapeList.remove(shape)) {
			shape._parent = null;
			return;
		}
	}
	
	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		return shapeList.get(index);
	}

	public int shapeCount() {
		return shapeList.size();
	}
	
	public int indexOf(Shape shape){
		return shapeList.indexOf(shape);
	}
	
	public boolean contains(Shape shape) {
		return shapeList.contains(shape);
	}
}