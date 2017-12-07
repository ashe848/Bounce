package bounce.views;

import bounce.NestingShape;
import bounce.ShapeModel;
import bounce.ShapeModelEvent;
import bounce.ShapeModelListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

public class Task2 extends Task1 implements ShapeModelListener {

	private List<TreeModelListener> listeners = new ArrayList<TreeModelListener>();

	public Task2(ShapeModel shapeModel) {
		super(shapeModel);
	}

	public void removeTreeModelListener(TreeModelListener treeModelListener) {
		listeners.remove(treeModelListener);
	}

	public void addTreeModelListener(TreeModelListener treeModelListener) {
		listeners.add(treeModelListener);
	}

	public void update(ShapeModelEvent event) {
		
		Object source = this;
		
		NestingShape parent = event.parent();
		Object[] path;
		if (parent == null) {
			path = event.operand().path().toArray();
		} else {
			path = parent.path().toArray();
		}
		
		int[] childIndices = new int[] {event.index()};
		
		Object[] children = new Object[] {event.operand()};

		TreeModelEvent treeModelEvent = new TreeModelEvent(source, path, childIndices, children);

		
		switch (event.eventType()) {
		case ShapeAdded:
			for (TreeModelListener treeModelListener:listeners) {
				treeModelListener.treeNodesInserted(treeModelEvent);
			}
			break;
		case ShapeRemoved:
			for (TreeModelListener treeModelListener:listeners) {
				treeModelListener.treeNodesRemoved(treeModelEvent);
			}
			break;
		case ShapeMoved:
			break;
		}
	}
}