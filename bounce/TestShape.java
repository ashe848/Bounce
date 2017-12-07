package bounce;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape and RectangleShape.
 * 
 */

/**
 * @author Ian Warren
 * 
 */
public class TestShape {
	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUpPainter() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,85,45)(rectangle 112,35,85,45)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,85,45)(rectangle 50,35,85,45)(rectangle 38,50,85,45)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		RectangleShape shape = new RectangleShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(rectangle 10,20,85,45)(rectangle 0,35,85,45)(rectangle 12,50,85,45)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom left corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndLeft() {
		RectangleShape shape = new RectangleShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(rectangle 10,90,85,45)(rectangle 0,90,85,45)(rectangle 12,75,85,45)", _painter.toString());
	}
	
	/**
	 * @author Abby Shen
	 */
	@Test
	public void testOvalPaint() {
		OvalShape ovalShape = new OvalShape(100, 20, 12, 15);
		ovalShape.paint(_painter);
		assertEquals("(oval 100,20,85,45)", _painter.toString());
	}
	
	@Test
	public void testSmallGemPaint() {
		GemShape gemShape = new GemShape(0, 0, 12, 15, 24, 36);
		gemShape.paint(_painter);
		assertEquals("(line 12,0,12,0)(line 12,0,24,18)(line 24,18,12,36)(line 12,36,12,36)" 
				+ "(line 12,36,0,18)(line 0,18,12,0)", _painter.toString());
	}
	
	@Test
	public void testRegGemPaint() {
		GemShape gemShape = new GemShape(10, 40, 12, 15, 45, 35);
		gemShape.paint(_painter);
		assertEquals("(line 30,40,35,40)(line 35,40,55,57)(line 55,57,35,75)(line 35,75,30,75)"
				+ "(line 30,75,10,57)(line 10,57,30,40)", _painter.toString());
	}
	
	@Test
	public void testDyRectPaint() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(100, 20, 12, 15);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(rectangle 100,20,85,45)", _painter.toString());
	}
	
	@Test
	public void testDyRectOffTop() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(0, 10, 12, -15, Color.BLUE);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(125, 135);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(125, 135);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(filled rectangle 0,10,85,45,java.awt.Color[r=0,g=0,b=255])(rectangle 12,0,85,45)(rectangle 24,15,85,45)", _painter.toString());
	}
	
	@Test
	public void testDyRectOffLeft() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(10, 0, -12, 15, Color.BLUE);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(125, 135);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(125, 135);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(filled rectangle 10,0,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 0,15,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 12,30,85,45,java.awt.Color[r=0,g=0,b=255])", _painter.toString());
	}
	
	@Test
	public void testDyRectOffBottom() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(0, 450, 12, 65, Color.BLUE);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(filled rectangle 0,450,85,45,java.awt.Color[r=0,g=0,b=255])(rectangle 12,455,85,45)(rectangle 24,390,85,45)", _painter.toString());
	}
	
	@Test
	public void testDyRectOffRight() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(400, 40, 30, 10, Color.BLUE);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(filled rectangle 400,40,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 415,50,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 385,60,85,45,java.awt.Color[r=0,g=0,b=255])", _painter.toString());
	}
	
	@Test
	public void testDyRectOffTopLeft() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(10, 10, -15, -15, Color.BLUE);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(125, 135);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(125, 135);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(filled rectangle 10,10,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 0,0,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 15,15,85,45,java.awt.Color[r=0,g=0,b=255])", _painter.toString());
	}
	
	@Test
	public void testDyRectOffTopRight() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(400, 10, 30, -15, Color.BLUE);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(filled rectangle 400,10,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 415,0,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 385,15,85,45,java.awt.Color[r=0,g=0,b=255])", _painter.toString());
	}
	
	@Test
	public void testDyRectOffBottomLeft() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(10, 450, -15, 65, Color.BLUE);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(filled rectangle 10,450,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 0,455,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 15,390,85,45,java.awt.Color[r=0,g=0,b=255])", _painter.toString());
	}
	
	@Test
	public void testDyRectOffBottomRight() {
		DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(400, 450, 30, 65, Color.BLUE);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		dynamicRectangleShape.move(500, 500);
		dynamicRectangleShape.paint(_painter);
		assertEquals("(filled rectangle 400,450,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 415,455,85,45,java.awt.Color[r=0,g=0,b=255])(filled rectangle 385,390,85,45,java.awt.Color[r=0,g=0,b=255])", _painter.toString());
	}
}
