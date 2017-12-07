package bounce.views;

import bounce.NestingShape;
import bounce.Shape;
import bounce.ShapeModel;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Task1 implements TreeModel {

	private ShapeModel adaptee;
	
	public Task1(ShapeModel shapeModel) {
		adaptee = shapeModel;
	}

	public Object getRoot() {
		return adaptee.root();
	}

	public int getChildCount(Object parent) {
		int childCount = 0;
		
		if (parent instanceof NestingShape) {
			NestingShape nestingShape = (NestingShape) parent;
			childCount = nestingShape.shapeCount();
		}
		
		return childCount;
	}
	
	public boolean isLeaf(Object node) {
		return !(node instanceof NestingShape);
	}
	
	public Object getChild(Object parent, int index) {
		if (parent instanceof NestingShape) {
			NestingShape parentNestingShape = (NestingShape) parent;
			try {
				return parentNestingShape.shapeAt(index);
			} catch (IndexOutOfBoundsException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	public int getIndexOfChild(Object parent, Object child) {
		int indexOfChild = -1;
		
		if (parent instanceof NestingShape && child instanceof Shape) {
			NestingShape parentNestingShape = (NestingShape) parent;
			Shape childShape = (Shape) child;
			indexOfChild = parentNestingShape.indexOf(childShape);
		}
		
		return indexOfChild;
	}
	
	public void addTreeModelListener(TreeModelListener treeModelListener) {
	}

	public void removeTreeModelListener(TreeModelListener treeModelListener) {
	}

	public void valueForPathChanged(TreePath treePath, Object newValueForPath) {
	}

}