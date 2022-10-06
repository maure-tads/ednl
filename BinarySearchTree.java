import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private Node root;

	public void insert(Integer value) {
		Node parent = null;
		Node v = root;
		while(v != null) {
			parent = v;
			v = v.getKey() > value ? v.getLeft() : v.getRight();
		}

		Node temp = new Node(value);
		temp.setParent(parent);

		if(parent == null) {
			root = temp;
		} else if(parent.getKey() > value) {
			parent.setLeft(temp);
		} else {
			parent.setRight(temp);
		}
	}

	public Integer height() {
		return height(root);
	}

	public Integer height(Node n) {
		if(n == null) {
			return 1;
		}
		int leftHeight = height(n.getLeft());
		int rightHeight = height(n.getRight());
		return leftHeight > rightHeight ? leftHeight : rightHeight;
	}




	public void print() {
		List<Integer> lista = inOrderList();
		int height = height();

		for(int i = 0; i < height; i++) {

		}
	}

	public List<Integer> inOrderList() {
		return inOrderList(root);
	}

	private List<Integer> inOrderList(Node n) {
		List<Integer> l = new ArrayList();
		if(n != null) {
			l.addAll(inOrderList(n.getLeft()));
			l.add(n.getKey());
			l.addAll(inOrderList(n.getRight()));
		}
		return l;
	}

	
	public List<Integer> inOrderList() {
		return inOrderList(root);
	}

	private List<Integer> inOrderList(Node n) {
		List<Integer> l = new ArrayList();
		if(n != null) {
			l.addAll(inOrderList(n.getLeft()));
			l.add(n.getKey());
			l.addAll(inOrderList(n.getRight()));
		}
		return l;
	}


	public List<Integer> preOrderList() {
		return preOrderList(root);
	}

	private List<Integer> preOrderList(Node n) {
		List<Integer> l = new ArrayList();
		if(n != null) {
			l.add(n.getKey());
			l.addAll(preOrderList(n.getLeft()));
			l.addAll(preOrderList(n.getRight()));
		}
		return l;
	}

	public void print() {
		print(root);
	}

	
	public void print(Node n) {
		
	}




	class Node {
		private Node parent;
		private Node left;
		private Node right;
		private Integer key;

		public Node(Integer key) {
			this.key = key;
		}

		public Node getParent() {
			return this.parent;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}

		public Integer getKey() {
			return this.key;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}
	
		public void setKey(Integer key) {
			this.key = key;
		}
	}

}